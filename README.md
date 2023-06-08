Lombok
Anotaciones
@val : Sirve para crear una constante (final), se infiere el tipo de dato y una vez inferido no se puede cambiar
Ej:
final String type = "texto"
val type = "texto"
@var : Sirve para crear una variale, se infiere el tipo de dato y una vez inferido no se puede cambiar el tipo de dato , pero si el valor ya inferido. Esto ya esta por default en Java 10
Ej:
String type = "texto"
var type = "texto"
@NonNull : Sirve para marcar un campo como no nulo, en caso que sea nulo se genera una exception
Ej:
public void setNombre(@NonNull String nombre) {
this.nombre = nombre;
}
@Cleanup : Sirve para liberar recursos
Ej:
   try{
        @Cleanup
        Archivo a = new Archivo();
        a.write("prueba","prueba.txt");
    } catch (IOException e) {
        e.printStackTrace();
    }
Ej2: Cuando no implementas un Closable
    try{
        @Cleanup("close")
        Archivo a = new Archivo();
        a.write("prueba dos","pruebaDos.txt");
    } catch (IOException e) {
        e.printStackTrace();
    }
@Getter and @Setter : Los metodos de toda la vida
Ej:
@Getter (value = AccessLevel.PUBLIC)
@Setter (value = AccessLevel.PRIVATE)
public class Cuenta {
private BigDecimal idCuenta;
private boolean isActive;

    public void setValues (){
        setIdCuenta(new BigDecimal("100001"));
        setActive(true);
    }
}
@ToString : para poder generer el override del toStrig()
@ToString.Exclude para omitir un campo en el toString()
Ej:
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
    public class Cuenta {
    @EqualsAndHashCode.Include
    private BigDecimal idCuenta;
    
        @EqualsAndHashCode.Include
        private boolean isActive;
    
        @ToString.Exclude
        private String name;
    
        public void setValues (){
            setIdCuenta(new BigDecimal("100001"));
            setActive(true);
            setName("angel");
        }
    }
@NoArgsConstructor : constructor vacio
@RequiredArgsConstructor : constructor para ciertos atributos , para utilziarlo solo anotar los atributos con @NonNully generara el constructor
@AllArgsConstructor : constructor para todos los atributos
@Getter (value = AccessLevel.PUBLIC)
@Setter (value = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
public class Cuenta {

    @EqualsAndHashCode.Include
    private BigDecimal idCuenta;

    @EqualsAndHashCode.Include
    private boolean isActive;

    @ToString.Exclude
    //@EqualsAndHashCode.Exclude
    private String name;

    public void setValues (){
        setIdCuenta(new BigDecimal("100001"));
        setActive(true);
        setName("angel");
    }
}
@Data : Hace todo lo de :Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode
@Data
public class Persona {
    private Integer edad;
    private String nombre;
    private char genero;
}
