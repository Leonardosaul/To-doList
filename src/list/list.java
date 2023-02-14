package list;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class list {
    
    public static Scanner sc=new Scanner(System.in);
    public static ArrayList<ArrayList> bsgeneral=new ArrayList();
    public static int cont=0;
    
    public static void main(String[] args) {
        inicio();
    }
    
    public static void agregar(){
        boolean band=true;
        String descp;
        
        //intanciando y creando la fecha y hora
        LocalDateTime fecha=LocalDateTime.now();
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        
        String Fecha=fecha.format(formato);
        //
        
        bsgeneral.add(new ArrayList<String>()); //creando nueva sublista cada ves que se presiona
        
        System.out.println("Ingrese el titulo de la tarea: ");
        String titulo=sc.next();
        
        sc.nextLine();  //limpiando buffer 
        
        do {    
            System.out.println("Ingrese la descripcion de la tarea (maximo 60 caracteres): ");
            descp=sc.nextLine();
            
            if(descp.length()<=60){
                band=false;
            }
        } while (band);     //comprobar el limite de caracteres
        
        bsgeneral.get(cont).add(titulo);
        bsgeneral.get(cont).add(Fecha);
        bsgeneral.get(cont).add(descp);
        bsgeneral.get(cont).add("Incompleto");
        
        System.out.println("Tarea Agregada Exitosamente\n");
    }
    
    public static void mostrar(){
        if(bsgeneral.size()==0){
            System.out.println("No hay tareas");
        }else{
           for(int i=0;i<bsgeneral.size();i++){
                System.out.println((i+1)+".\tTitulo: "+bsgeneral.get(i).get(0)+"\tFecha: "+bsgeneral.get(i).get(1));
                System.out.println("Descripcion: "+bsgeneral.get(i).get(2));
                System.out.println("Estado: "+bsgeneral.get(i).get(3)+"\n");
            } 
        }
        System.out.println();
    }
    
    public static void modificar(){
        System.out.print("Ingrese el numero de la tarea a modificar: ");
        int op=sc.nextInt();
        
        System.out.println("Completo la tarea??\n1)Si\n2)No");
        int md=sc.nextInt();
        
        if(md==1){
            bsgeneral.get(op-1).set(3, "Completo");
        }
        
        System.out.println();
    }
    
    public static void eliminar(){
        System.out.print("Ingrese el numero de tarea a eliminar: ");
        int op=sc.nextInt();
        
        bsgeneral.remove(op-1);
        
        System.out.println("Eliminado Exitosamente\n");
    }
    
    public static void inicio(){
        boolean band=true;
        
        do {
            System.out.println("Bienvenido.. He sido creado para llevar sus tareas");
            System.out.println("1)Crear tarea\n2)Mostrar tarea\n3)Modificar estado de tarea\n4)Eliminar tarea\n(Presione cualquier numero para salir)");
            int op=sc.nextInt();
            
            switch (op) {
                case 1:
                    agregar();
                    cont++;
                    break;
                case 2:
                    mostrar();
                    break;
                case 3:
                    modificar();
                    break;
                case 4:
                    eliminar();
                    break;
                default:
                    band=false;
            }
        } while (band);
    }
}
