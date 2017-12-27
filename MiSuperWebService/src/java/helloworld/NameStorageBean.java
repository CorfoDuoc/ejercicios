
package helloworld;

import javax.ejb.Singleton;

//Esto es un pojo basico con get y set, ni un brillo 
//el unico brillo es que hace SINGLETON y esta clase es
//ocupada por HelloWordResource que es el verdadero WEB Service REST
//por que es esta ultima clase la que hace GET y PUT
//definiendo de esta forma los metodos que el CLIENTE Web Service
//REST podra invocar

/** Singleton session bean used to store the name parameter for "/helloWorld" resource
 *
 * @author mkuchtiak
 */
@Singleton  //hace el NEW automaticamente, pero solo una vez por ser Singleton
public class NameStorageBean {

    // name field
    private String name = "";

    //esto es lo que invocara el GET del web service
    //greeting
    public String getName() {
        return name;
    }

    //esto es lo que invocara el PUT del web service
    public void setName(String name) {
        this.name = name;
    }
 
}
