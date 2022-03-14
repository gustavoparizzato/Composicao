package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.TrabalhadorLevel;

public class Trabalhador {

	private String nome;
	private TrabalhadorLevel nivel;
	private Double baseSalario;
	
	private Departamento departamento;
	private List<HoraContrato> contratos = new ArrayList<>();
	
	public Trabalhador() {
	}

	public Trabalhador(String nome, TrabalhadorLevel nivel, Double baseSalario, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.baseSalario = baseSalario;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TrabalhadorLevel getNivel() {
		return nivel;
	}

	public void setLevel(TrabalhadorLevel nivel) {
		this.nivel = nivel;
	}

	public Double getBaseSalario() {
		return baseSalario;
	}

	public void setBaseSalario(Double baseSalario) {
		this.baseSalario = baseSalario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento department) {
		this.departamento = department;
	}

	public List<HoraContrato> getContratos() {
		return contratos;
	}

	public void addContrato(HoraContrato contrato) {
		contratos.add(contrato);
	}
	
	public void removeContrato(HoraContrato contrato) {
		contratos.remove(contrato);
	}
	
	public double income(int ano, int mes) {
		double sum = baseSalario;
		Calendar cal = Calendar.getInstance();
		for (HoraContrato c : contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if (ano == c_ano && mes == c_mes) {
				sum += c.valorTotal();
			}
		}
		return sum;
	}
}