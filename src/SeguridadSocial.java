/**
 * Created by Mateo on 13/11/16.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class SeguridadSocial {
    private List<Persona> personasList;

    public SeguridadSocial() {
        personasList = new ArrayList<>();

    }

    public void altaPersona(Persona Persona) {personasList.add(Persona);}

    public void bajaPersona(String dni) {
        personasList.removeIf(Persona -> Persona.getDni().equals(dni));
    }


    public Persona obtenerPersonaPorDNI(String dni) {

        Persona encontrada = null;

        for(Persona persona:personasList){
            if(persona.getDni().equals(dni)){
                encontrada=persona;
                break;
            }
        }
        return encontrada;

    }

    public Persona obtenerPersonaPorNumSS(String numSS) {
        Persona encontrada = null;

        for(Persona persona:personasList){
            if(persona.getNumSS().equals(numSS)){
                encontrada=persona;
                break;
            }
        }
        return encontrada;

    }

    public List<Persona> obtenerPersonasRangoSalarial(double min, double max) {
        return personasList.stream().filter(persona -> persona.getSalario()> min && persona.getSalario()< max).collect(Collectors.toList());
    }


    public List<Persona> obtenerPersonasMayoresQue(int edad){
        return personasList.stream().filter(persona -> persona.getEdad()> edad ).collect(Collectors.toList());
    }


    public Persona obtenerPersonaPorSalarioMinimo(){
        Persona min= null;
        for (Persona persona: personasList){

            if(min==null || persona.getSalario()<min.getSalario()){
                min=persona;
            }
        }
        return min;
    }

    public Persona obtenerPersonaPorSalarioMaximo(){

        Persona max = null;
        for (Persona persona: personasList){

            if(max==null || persona.getSalario()>max.getSalario()){
                max=persona;
            }
        }
        return max;
    }

    public List<Persona> obtenerTodas(){
        return personasList;
    }

    @Override
    public String toString() {
        return "SeguridadSocial{" +
                "personasList=" + personasList +
                '}';
    }
}