import java.util.Objects;

public class LinePattern {

    int numeros;
    int letrasMaiusculas;
    int letrasMinusculas;
    int espacosEmBranco;
    int caracteresEspeciais;
    int caracteresDeControle;
    int caracteresUnicode;
    String exemplo;

    // Construtor para inicializar a string de exemplo
    public LinePattern(String exemplo) {
        this.exemplo = exemplo;
        // Contar os tipos de caracteres
        countCharacterTypes();
    }

    // Contar os diferentes tipos de caracteres na string exemplo
    private void countCharacterTypes() {
        // Percorrer cada caractere da string exemplo
        for (char c : exemplo.toCharArray()) {
            if (Character.isDigit(c)) {
                numeros++; // Incrementa para números
            } else if (Character.isUpperCase(c)) {
                letrasMaiusculas++; // Incrementa para letras maiúsculas
            } else if (Character.isLowerCase(c)) {
                letrasMinusculas++; // Incrementa para letras minúsculas
            } else if (Character.isWhitespace(c)) {
                espacosEmBranco++; // Incrementa para espaços em branco
            } else if (isControlCharacter(c)) {
                caracteresDeControle++; // Incrementa para caracteres de controle
            } else if (isUnicodeCharacter(c)) {
                caracteresUnicode++; // Incrementa para caracteres Unicode
            } else {
                caracteresEspeciais++; // Incrementa para caracteres especiais
            }
        }
    }

    // Verificar se o caractere é um caractere de controle
    private boolean isControlCharacter(char c) {
        return c < 32;  // Caractere de controle tem valor ASCII entre 0 e 31
    }

    // Verificar se o caractere é um caractere Unicode (não numérico ou alfabético)
    private boolean isUnicodeCharacter(char c) {
        // Considera como Unicode se o caractere não é um dígito ou letra
        return !Character.isLetterOrDigit(c);
    }

    public int getNumeros() {
        return numeros;
    }

    public int getLetrasMaiusculas() {
        return letrasMaiusculas;
    }

    public int getLetrasMinusculas() {
        return letrasMinusculas;
    }

    public int getEspacosEmBranco() {
        return espacosEmBranco;
    }

    public int getCaracteresEspeciais() {
        return caracteresEspeciais;
    }

    public int getCaracteresDeControle() {
        return caracteresDeControle;
    }

    public int getCaracteresUnicode() {
        return caracteresUnicode;
    }

    public String getExemplo() {
        return exemplo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinePattern that = (LinePattern) o;
        return numeros == that.numeros &&
                letrasMaiusculas == that.letrasMaiusculas &&
                letrasMinusculas == that.letrasMinusculas &&
                espacosEmBranco == that.espacosEmBranco &&
                caracteresEspeciais == that.caracteresEspeciais &&
                caracteresDeControle == that.caracteresDeControle &&
                caracteresUnicode == that.caracteresUnicode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeros, letrasMaiusculas, letrasMinusculas, espacosEmBranco,
                caracteresEspeciais, caracteresDeControle, caracteresUnicode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n")
                .append("Exemplo de referência do padrão: ").append(exemplo).append("\n");

        if (numeros > 0) sb.append("Números: ").append(numeros).append("\n");
        if (letrasMaiusculas > 0) sb.append("UpperCase: ").append(letrasMaiusculas).append("\n");
        if (letrasMinusculas > 0) sb.append("LowerCase: ").append(letrasMinusculas).append("\n");
        if (espacosEmBranco > 0) sb.append("Blank: ").append(espacosEmBranco).append("\n");
        if (caracteresEspeciais > 0) sb.append("Especiais: ").append(caracteresEspeciais).append("\n");
        if (caracteresDeControle > 0) sb.append("Controle: ").append(caracteresDeControle).append("\n");
        if (caracteresUnicode > 0) sb.append("Unicode: ").append(caracteresUnicode).append("\n");
        return sb.toString();
    }

}
