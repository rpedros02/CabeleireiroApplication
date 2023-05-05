package com.company.enums;

/**
 * Género da Pessoa enumerado por três condições:
 * → Masculino;
 * → Feminino;
 * → Não-Binário.
 */
public enum Genero {
    MASCULINO, FEMININO, NAOBINARIO;

    /**
     * Transforma o género da Pessoa em texto corrente para output.
     * Override do método toString() com parâmetros.
     * @param genero Género a transformar
     * @return Género da Pessoa em formato de output.
     */
    public String toString(Genero genero) {
        switch (genero) {
            case MASCULINO -> {
                return "Masculino";
            }
            case FEMININO -> {
                return "Feminino";
            }
            default -> {
                return "Não-Binário";
            }
        }
    }
}
