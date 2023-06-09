# Lombok

## Anotaciones 

### @val : Sirve para crear una constante (final), se infiere el tipo de dato y una vez inferido no se puede cambiar 
    Ej: final String type = "texto" val type = "texto" 

### @var : Sirve para crear una variale, se infiere el tipo de dato y una vez inferido no se puede cambiar el tipo de dato , pero si el valor ya inferido. Esto ya esta por default en Java 10 
    Ej: String type = "texto" var type = "texto" 

### @NonNull : Sirve para marcar un campo como no nulo, en caso que sea nulo se genera una exception 
    Ej: public void setNombre(@NonNull String nombre) { this.nombre = nombre; } 

### @Cleanup : Sirve para liberar recursos 
    Ej: try{ 
            @Cleanup Archivo a = new Archivo(); 
            a.write("prueba","prueba.txt"); 
            } catch (IOException e) {
                e.printStackTrace(); 
            } 
    Ej2: Cuando no implementas un Closable 
        try{ 
                @Cleanup("close") Archivo a = new Archivo(); 
                a.write("prueba dos","pruebaDos.txt"); 
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 


### @Getter and @Setter : Los metodos de toda la vida 
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

### @ToString : para poder generer el override del toStrig() 
### @ToString.Exclude para omitir un campo en el toString() 
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

### @NoArgsConstructor : constructor vacio 
### @RequiredArgsConstructor : constructor para ciertos atributos , para utilziarlo solo anotar los atributos con @NonNull generara el constructor 
### @AllArgsConstructor : constructor para todos los atributos 
    @Getter (value = AccessLevel.PUBLIC) 
    @Setter (value = AccessLevel.PRIVATE) 
    @ToString 
    @EqualsAndHashCode(onlyExplicitlyIncluded = true) 
    @NoArgsConstructor 
    @AllArgsConstructor 
    //@RequiredArgsConstructor public class Cuenta {
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
### @Data : Hace todo lo de :Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode 
    @Value
    public class Registro {
        private Integer idRegistro;
        private Date fechaRegistro;
        private String firmaDigital;
    }

### @Builder : Es una especie de constructor pero que ayuda al inicializar valores, ayuda para clases con muchos atributos
    public static void builder(){
        Cancion c = Cancion.builder().nombre("Life in the Tropics").
                autor("Cienfue").fechaLanzamiento(new Date()).album("Life in the Tropics").
                genero("Indie").duracion(2.56f).build();
        System.out.println(c.toString());
    }

### @Builder.Default : Sirve para generar un valor por defaul al crear un objecto
    @Builder
    @ToString
    public class Cancion {
        private String nombre;
        private String autor;
        private Date fechaLanzamiento;
        private String album;
        private String genero;
        private float duracion;
        @Builder.Default
        private int anio = 2023;
    }

### @With: Sirve para clonar valores, puede ser usado a nivel clase o a nivel atributo
    @With
    @ToString
    @AllArgsConstructor
    public class Coordenada {
        private float x;
        private float y;
    }

