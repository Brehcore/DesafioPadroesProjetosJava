
/**
 * Padrão Estrutural Decorator
 * @author brehs
 * 
 */

interface Bebida {
    String getDescricao();
    double custo();
}

class Cafe implements Bebida {
    @Override
    public String getDescricao() {
        return "Café";
    }

    @Override
    public double custo() {
        return 5.0;
    }
}

abstract class Decorator implements Bebida {
    protected Bebida bebida;

    public Decorator(Bebida bebida) {
        this.bebida = bebida;
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao();
    }

    @Override
    public double custo() {
        return bebida.custo();
    }
}

class Leite extends Decorator {
    public Leite(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + ", Leite";
    }

    @Override
    public double custo() {
        return bebida.custo() + 1.0;
    }
}

class Açúcar extends Decorator {
    public Açúcar(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + ", Açúcar";
    }

    @Override
    public double custo() {
        return bebida.custo() + 0.5;
    }
}

public class Estrutural {
    public static void main(String[] args) {

        Bebida meuCafé = new Cafe();
        System.out.println("Bebida: " + meuCafé.getDescricao());
        System.out.printf("Custo: R$ " + "%.2f\n", meuCafé.custo());

        meuCafé = new Leite(meuCafé);
        meuCafé = new Açúcar(meuCafé);
        System.out.println("Bebida: " + meuCafé.getDescricao());
        System.out.printf("Custo: R$" + "%.2f\n", meuCafé.custo());
    }
}
