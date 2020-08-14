package br.com.vinicius.fatura.decoder;

import br.com.vinicius.fatura.exceptions.ClientNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class PersonClientDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        if(response.status() == 404) {
            return new ClientNotFoundException();
        }
        return errorDecoder.decode(methodKey, response);
    }
}
