package br.edu.qi.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.edu.qi.bean.LaboratorioBean;
import br.edu.qi.dto.Laboratorio;
import br.edu.qi.util.Numeric;

@ManagedBean
@ViewScoped
public class LaboratorioMB {

	@EJB
	LaboratorioBean bean;
	
	private String codTurma;
	private String codDisciplina;
	private String qtdeMaquinas;
	private String msgAviso;
	
	public void save()
	{
		try
		{
			this.setMsgAviso("");
			this.validation();
			
			Laboratorio dto = new Laboratorio();
			
			dto.setCodTurma(this.getCodTurma());
			dto.setCodDisciplina(Integer.parseInt(this.getCodDisciplina()));
			dto.setQtdeMaquinas(Integer.parseInt(this.getQtdeMaquinas()));
			
			bean.save(dto);
			
			this.setMsgAviso("Gravação com sucesso");
			
		}catch(Exception ex)
		{
			this.setMsgAviso("");
			this.setMessage("msgErro", ex.getMessage());
		}
	}
	
	public String getCodTurma() {
		return codTurma;
	}
	public void setCodTurma(String codTurma) {
		this.codTurma = codTurma;
	}
	public String getCodDisciplina() {
		return codDisciplina;
	}
	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}
	public String getQtdeMaquinas() {
		return qtdeMaquinas;
	}
	public void setQtdeMaquinas(String qtdeMaquinas) {
		this.qtdeMaquinas = qtdeMaquinas;
	}
	public String getMsgAviso() {
		return msgAviso;
	}
	public void setMsgAviso(String msgAviso) {
		this.msgAviso = msgAviso;
	}
	
	private void setMessage(String obj,String msg)
	{
		/* Cria uma mensagem. */
	      FacesMessage message = new FacesMessage(msg);
	/* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
	      FacesContext.getCurrentInstance().addMessage(obj, message);


	}
	private void validation() throws Exception
	{
		if (this.getCodTurma().trim().length()==0)
			throw new Exception("Informe a turma");
		if (!Numeric.isNumeric(this.getCodDisciplina().trim()))
			throw new Exception("Código da disc. inválido");
		if (!Numeric.isNumeric(this.getQtdeMaquinas()))
			throw new Exception("Qtde máquinas inválido");	
	}
	
}
