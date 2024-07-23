package controller;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import model.entity.Calculo;
import model.entity.Livro;
import model.service.CalculoService;
import view.CalculoForm;


public class CalculoController implements IController {

    private Calculo calculo;
    private CalculoForm frame;

    public void executa(Object view) {
        frame = (CalculoForm) view;
        calculo = new Calculo();
        calculo.setValorPrincipal(
                Double.parseDouble(frame.getTxtValorPrincipal().getText())
        );
        calculo.setTaxa(Double.parseDouble(frame.getTxtTaxa().getText()));
        calculo.setMeses(Integer.parseInt(frame.getTxtMeses().getText()));
        calculo.setTipo(frame.getRdBtnSimples().isSelected() ?
                Calculo.TipoJuros.SIMPLES : Calculo.TipoJuros.COMPOSTOS
        );

        calcular(calculo);

        String montante = doubleFormat(calculo.getMontante());
        String juros = doubleFormat(calculo.getTotalJuros());

        frame.getTxtTotJuros().setText(juros);
        frame.getTxtMontante().setText(montante);
    }
    
    
    
    
    private Calculo calcular(Calculo calculo) {
        CalculoService service = new CalculoService();

        Calculo resultado;
        if (calculo.getTipo().getValor() == 1) {
            resultado = service.jurosSimples(calculo);
        } else {
            resultado = service.jurosCompostos(calculo);
        }
        return resultado;
    }

    private String doubleFormat(Double aDouble) {
        NumberFormat nf =
                NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        nf.setMaximumFractionDigits(2);
        return nf.format(aDouble);
    }




	@Override
	public List<Livro> pesquisar(Object view) {
		return null;
	}




	@Override
	public void alterar(Object view) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void excluir(Integer codigo) {
		// TODO Auto-generated method stub
		
	}


}
