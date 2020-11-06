package pt.ipg.olamundo;

public class TemperaturaFarenheit extends Temperatura{
    public TemperaturaFarenheit(double valor){//guarda o valor na classe temperatura
        this.valor = valor;
    }

    @Override
    public double GetFahrenheit() {
        return 0;
    }

    @Override
    public double GetCelsius() {
        return (valor - 32) * 5.0 / 9.0;
    }
}
