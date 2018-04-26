public class Verificador {

    private int[] calculado;
    private int[] recebido;

    public String verifica(int n){

        calculado = new int[11];
        recebido = new int[11];

        for (int i=0; i<10; i++){
            int digito = String.valueOf(java.lang.Math.abs(n)).charAt(i);
            recebido[i] = digito;
            calculado[i] = digito;
        }
        calculado[9] = 0;
        calculado[10] = 0;

        GeraVerificador(1);
        GeraVerificador(2);

        if(calculado[9] == recebido[9] && calculado[10] == recebido[10])
            return "Válido";
        else
            return "Inválido";
    }

    public int[] getCalculado(){
        return calculado;
    }

    public int[] getRecebido(){
        return recebido;
    }

    public void GeraVerificador(int posicao){
        int qtdFor, peso;

        if(posicao == 1){
            qtdFor = 10;
            peso = 10;
        } else {
            qtdFor = 11;
            peso = 11;
        }

        int[] arrayMultiplicacoes = new int[11];
        for(int i=0; i<qtdFor; i++){
            arrayMultiplicacoes[i] = (calculado[i]*peso);
            peso--;
        }

        int totalSomatoria = 0;
        for (int i=0; i<qtdFor; i++){
            totalSomatoria += arrayMultiplicacoes[i];
        }

        int restoDaDivisao = totalSomatoria % 11;
        if(restoDaDivisao<2){
            calculado[(qtdFor - 1)] = 0;
        } else {
            calculado[(qtdFor - 1)] = 11 - restoDaDivisao;
        }
    }
}
