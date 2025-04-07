package CreationalPatterns.Builder;

import AbstractFactory.AbstractProductVideoGameConsole;

public class Personaje {
    String nombre;
    String dialogo;
    String tipo;
    String descripcion;
    float nivel;
    float peso;
    float experiencia;
    float ataque;
    float defensa;
    float velocidad;
    //  PROBLEMA, EL CONSTRUCTOR ES MUY COMPLEJO O ESTA SATURADO DE PARAMETROS,
    //  NECESITAMOS UNA FORMA DE QUE LA CONSTRUCCION DE ESTE OBJETO SEA MENOS COMPLEJO.
    Personaje(String nombre, String dialogo, String tipo, String descripcion, float nivel, float peso, float experiencia, float ataque, float defensa, float velocidad) {
        this.nombre = nombre;
        this.dialogo = dialogo;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.peso = peso;
        this.experiencia = experiencia;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "nombre: "  + this.nombre + "\n"+
                "dialogo: "  + this.dialogo+ "\n"+
                "tipo: "  + this.tipo+ "\n"+
                "descripcion: "  + this.descripcion+ "\n"+
                "nivel: "  + this.nivel + "\n"+
                "peso: "  + this.peso+ "\n"+
                "experiencia: "  + this.experiencia+ "\n"+
                "ataque: "  + this.ataque+ "\n"+
                "defensa: "  + this.defensa + "\n"+
                "velocidad: "  + this.velocidad;
    }

    public static class Builder{
        String nombre="";
        String dialogo="";
        String tipo="";
        String descripcion="";
        float nivel=1;
        float peso=1;
        float experiencia=0;
        float ataque=5;
        float defensa=5;
        float velocidad=5;
        /* plantilla para los metodos del builder
        public ClaseBuilderAnidada setParametro(tipoParametro p){
            this.parametro = p;
            return this;

         */
        public Builder setNombre(String nombre) {
            // retornamos el builder para poder volver a llamarlo
            this.nombre = nombre;
            return this;
        }
        public Builder setDialogo(String dialogo) {

            this.dialogo = dialogo;
            return this;

        }
        public Builder setTipo(String tipo) {
            this.tipo = tipo;
            return this;

        }
        public Builder setDescripcion(String descripcion){
            this.descripcion = descripcion;
            return this;
        }
        public Builder setNivel (float nivel){
            this.nivel = nivel;
            return this;

        }
        public Builder setPeso (float peso){
            this.peso = peso;
            return this;

        }
        public Builder setExperiencia (float experiencia){
            this.experiencia = experiencia;
            return this;
        }
        public Builder setAtaque (float ataque){
            this.ataque = ataque;
            return this;
        }
        public Builder setDefensa(float defensa){
            this.defensa = defensa;
            return this;

        }
        public Builder setVelocidad (float velocidad){
            this.velocidad = velocidad;
            return this;
        }
        public Personaje build(){
            return new Personaje(this.nombre,this.dialogo,this.tipo,this.descripcion,this.nivel,this.peso,this.experiencia,this.ataque,this.defensa,this.velocidad);
        }
    }


    /*



        public Builder setNombre(String nombre) {
            // retornamos el builder para poder volver a llamarlo
            this.nombre = nombre;
            return this;
        }
        public Builder setDialogo(String dialogo) {

            this.dialogo = dialogo;
            return this;

        }
        public Builder setTipo(String tipo) {
            this.tipo = tipo;
            return this;

        }
        public Builder setDescripcion(String descripcion){
            this.descripcion = descripcion;
            return this;
        }
        public Builder setNivel (float nivel){
            this.nivel = nivel;
            return this;

        }
        public Builder setPeso (float peso){
            this.peso = peso;
            return this;

        }
        public Builder setExperiencia (float experiencia){
            this.experiencia = experiencia;
            return this;
        }
        public Builder setAtaque (float ataque){
            this.ataque = ataque;
            return this;
        }
        public Builder setDefensa(float defensa){
            this.defensa = defensa;
            return this;

        }
        public Builder setVelocidad (float velocidad){
            this.velocidad = velocidad;
            return this;
        }
     */

}
