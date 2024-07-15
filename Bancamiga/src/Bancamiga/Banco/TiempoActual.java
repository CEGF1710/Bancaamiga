
package Bancamiga.Banco;

public class TiempoActual {

    private int horas;
    private int minutos;
    private int segundos;

    public TiempoActual(int horas) {
        this.horas = horas;
        this.minutos = 00;
        this.segundos = 0;
    }

    public TiempoActual(int horas, int minutos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = 0;
    }

    public TiempoActual(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    //Revisar que la operacion no sobrepase el tiempo de trabajo de taquilla.
    private boolean confirmarTiempo(int minutosAgregados) {
        if (horas == 15) {
            int temporal = minutos + minutosAgregados;
            if (temporal > 30) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    //Funcion que incrementa el tiempo automaticamente en funcion de minutos.
    public boolean incrementarTiempo(int minutosAgregados) {
        if (confirmarTiempo(minutosAgregados)) {
            minutos = minutos + minutosAgregados;
            if (minutos >= 60) {
                int diferencia = minutos - 60;
                horas++;
                minutos = 0;
                minutos = minutos + diferencia;
            }
            return true;
        } else {
            System.out.println("Solicitud sobrepasa la hora de fin de jornada. Terminando jornada laboral...");
            return false;
        }

    }

    public boolean incrementarTiempo(int minutosAgregados, int segundosAgregados) {
        int rollbackMinutos = this.minutos;
        int rollbackSegundos = this.segundos;
        if (confirmarTiempo(minutosAgregados)) {
            minutos = minutos + minutosAgregados;
            if (minutos >= 60) {
                int diferencia = minutos - 60;
                horas++;
                minutos = 0;
                minutos = minutos + diferencia;
            }
            //Evitando segundos de más
            if ((horas == 15) && (minutos == 30)) {
                if (segundos != 0) {
                    //Rollback de minutos.
                    minutos = rollbackMinutos;
                    return false;
                }
            } else {
                segundos = segundos + segundosAgregados;
                if (segundos >= 60) {
                    int diferenciaSegundos = segundos - 60;
                    minutos++;
                    segundos = 0;
                    segundos = segundos + diferenciaSegundos;
                }
            }
            return true;
        } else {
            System.out.println("Solicitud sobrepasa la hora de fin de jornada. Terminando jornada laboral.");
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(horas).append(":");
        if (Integer.toString(minutos).length() < 2) {
            sb.append("0");
            sb.append(minutos);
        } else {
            sb.append(minutos);
        }
        sb.append(":");
        if (Integer.toString(segundos).length() < 2) {
            sb.append("0");
            sb.append(segundos);
        } else {
            sb.append(segundos);
        }
        return sb.toString();
    }

}
