package com.mercadolivre.bootcamp.desafio.Exceptions;

public class NoCategoryException extends Exception {
    public NoCategoryException(Integer idCategoria) {
        super("essa categoria não existe vocÊ deve adicionar o seu produto em uma categoria válida ou então usar a categoria padrão id: " + String.valueOf(idCategoria));
    }
}
