public class Leitura {
  private double temperatura;
  private double umidade;
  private double co2; //medido em ppm (partes por milhão)
  
  Leitura(double temperatura, double umidade, double co2) {
    validaTemperatura(temperatura);
    validaUmidade(umidade);
    validaCo2(co2);
    
    this.temperatura = temperatura;
    this.umidade = umidade;
    this.co2 = co2;
  }
  
  public double getTemperatura() {
    return this.temperatura;
  }
  
  public double getUmidade() {
    return this.umidade;
  }
  
  public double getCo2() {
    return this.co2;
  }
  
  public void validaTemperatura(double temperatura) {
    if (temperatura < -255 || temperatura > 1000) {
      throw new IllegalArgumentException("Valor de temperatura inválido");
    }
  }
  
  public void setTemperatura(double temperatura) {
    validaTemperatura(temperatura);
    this.temperatura = temperatura;
  }
  
  public void validaUmidade(double umidade) {
    if (umidade <= 0 || umidade > 100) { //limite real beira 0,1% e 0,3%, menor medição real: 0,3% Irã
      throw new IllegalArgumentException("Valor de umidade inválido");
    }
  }
  
  public void setUmidade(double umidade) {
    validaUmidade(umidade);
    this.umidade = umidade;
  }
  
  public void validaCo2(double co2) {
    if (co2 < 0 || co2 > 1000000) { //como é em partes por milhão, 1 milhão = 100% de concentração
      throw new IllegalArgumentException("Valor de Co2 inválido");
    }
  }
  
  public void setCo2(double co2) {
    validaCo2(co2);
    this.co2 = co2;
  }
}

//usado só para testes, nn acho que vamos precisar
@Override
public String toString() {
    return "Temperatura: " + temperatura + "°C\n" + "Umidade: " + umidade + "%\n" + "Concentração de CO2: " + co2 + " ppm";
}

public double compara() {
    double media = (temperatura + umidade + co2)/3;
}

/*
// Captura o momento exato da leitura do sensor
Instant leituraSensor = Instant.now(); 

// Na hora de mostrar no gráfico para o usuário local:
ZonedDateTime horaLocal = leituraSensor.atZone(ZoneId.of("America/Sao_Paulo"));
*/