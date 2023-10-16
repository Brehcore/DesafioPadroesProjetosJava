
/**
 * Padrão Criacional Factory Method
 * @author brehs
 * 
 */

interface Veiculo {
 void mover();
}

class Carro implements Veiculo {
 @Override
 public void mover() {
     System.out.println("Carro está se movendo.");
 }
}

class Bicicleta implements Veiculo {
 @Override
 public void mover() {
     System.out.println("Bicicleta está se movendo.");
 }
}

interface FabricaVeiculo {
 Veiculo criarVeiculo();
}

class FabricaCarro implements FabricaVeiculo {
 @Override
 public Veiculo criarVeiculo() {
     return new Carro();
 }
}

class FabricaBicicleta implements FabricaVeiculo {
 @Override
 public Veiculo criarVeiculo() {
     return new Bicicleta();
 }
}

public class Criacional {

	public static void main(String[] args) {
		FabricaVeiculo fabricaCarro = new FabricaCarro();
        Veiculo meuCarro = fabricaCarro.criarVeiculo();
        meuCarro.mover();
        
        FabricaVeiculo fabricaBicicleta = new FabricaBicicleta();
        Veiculo minhaBicicleta = fabricaBicicleta.criarVeiculo();
        minhaBicicleta.mover();
    }
}

