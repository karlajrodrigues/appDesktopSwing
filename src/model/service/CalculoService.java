package model.service;

import model.dao.CalculoDao;
import model.entity.Calculo;


public class CalculoService {
    private CalculoDao dao;

    public CalculoService() {
        this.dao = new CalculoDao();
    }

    public CalculoDao getDao() {
        return dao;
    }

    public Calculo jurosSimples(Calculo calculo) {
        //valor principal
        double principal = calculo.getValorPrincipal();
        //taxa de juros igual a 1% ao mês -> 1/100 = 0.01
        double taxa = calculo.getTaxa() / 100;
        //número de meses
        int meses = calculo.getMeses();
        //total de juros
        double juros = principal * taxa * meses;
        //valor total -> juros + valor principal
        double montante = principal * (1 + (taxa * meses));

        calculo.setTotalJuros(juros);

        calculo.setMontante(montante);

        //Salvar no banco
        salvar(calculo);

        System.out.println("O total de juros a ser pago é: " + juros);
        System.out.println("O montante a ser pago é: " + montante);

        return calculo;
    }

    public Calculo jurosCompostos(Calculo calculo) {
        //valor principal
        double principal = calculo.getValorPrincipal();
        //taxa de juros igual a 1% ao mês -> 1/100 = 0.01
        double taxa = calculo.getTaxa() / 100;
        //número de meses
        int meses = calculo.getMeses();
        //valor total
        double montante = principal * Math.pow((1 + taxa), meses);
        //total de juros
        double juros = montante - principal;

        calculo.setTotalJuros(juros);

        calculo.setMontante(montante);

        salvar(calculo);

        System.out.println("O total de juros a ser pago é: " + juros);
        System.out.println("O montante a ser pago é: " + montante);
        
        return calculo;
    }

    public void salvar(Calculo calculo) {
        dao.salvar(calculo);
    }
}
