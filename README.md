# Laboratorio 1


## Nombres:
'''
Nicolas Cardenas Chaparro
'''
Daniel Felipe Rodriguez Villalba


## BBP Formula
### Part I - Introduction to Java Threads

1. Change the beginning with start() to run(). How does the output change? Why?.

R: Si, la salida cambia ya que al usar el start se ejecutan los hilos de manera desordenada, por lo que no se puede ver claramente cual esta ejecutando, sin embargo al iniciarlo con el metodo run, estos se ejecutan de manera seguida, es decir, ejecuta el metodo run de el primer hilo, lo termina y despues el metodo run del Segundo hilo y asi sucesivamente hasta terminar con el hilo 3.

### Part II - BBP Formula Exercise

## Dogs Race case

### Part I

#### 1: 

Como se puede observar en la imagen este es el rendimiento mostrado del programa con 1 hilo (hay 2 pero se debe tener en cuenta que el main es un hilo).

![Imagenes](https://github.com/danielrodriguezvillalba/ARSW-Lab1/blob/master/Imagenes/Verificando1Hilo.PNG)

#### 2:

El programa se dividio en las tres partes pedidas y el resultado en el codigo fue el siguiente:

![Imagenes](https://github.com/danielrodriguezvillalba/ARSW-Lab1/blob/master/Imagenes/TresHilosMain.PNG)

Seguido esto se procedio a medir el procesamiento de los nucleos por medio de JavaVisualVM y este fue el resultado

![Imagenes](https://github.com/danielrodriguezvillalba/ARSW-Lab1/blob/master/Imagenes/TresHilos.PNG)

#### 3:

Al modificar el programa con lo requerido por este punto, el codigo resultante fue el siguiente, en el cual se hace uso de buffer para la lectura de teclado y de la clase TimeTask para calcular los 5 segundos

![Imagenes](https://github.com/danielrodriguezvillalba/ARSW-Lab1/blob/master/Imagenes/Parte2Punto1Completp.PNG)

### Part III

#### 1:

Se hizo uso como se sugeria en el punto del metodo .join() de los hilos para que esto mostrara el numero del ganador, despues de acabados todos los hilos, el resultado fue este:

![Imagenes](https://github.com/danielrodriguezvillalba/ARSW-Lab1/blob/master/Imagenes/Join.PNG)

#### 2:

Al momento de correr la aplicación pudimos observar que esta al momento de mostrar las posiciones de los perros, habian unas que se repetian, por lo que identificamos al momento de acceder a las posiciones como zona critica.

#### 3:

Despues de identificar la zona critica se procedio a hacer uso de lo visto en clase con los bloques de Synchronized, en la clase Galgo en el metodo corra(), el codigo quedo de la siguiente manera:

![Imagenes](https://github.com/danielrodriguezvillalba/ARSW-Lab1/blob/master/Imagenes/SynchronyzedCode.PNG)

El resultado obtenido respecto a las posiciones, al ejecutar la aplicación con este codigo implementado, fue el siguiente:

![Imagenes](https://github.com/danielrodriguezvillalba/ARSW-Lab1/blob/master/Imagenes/Results.PNG)

#### 4:

En la clase MainCanodromo, en los metodos que implementaban estas funcionalidades se realizaron unos cambios, los cuales finalmente quedaron asi:

![Imagenes](https://github.com/danielrodriguezvillalba/ARSW-Lab1/blob/master/Imagenes/Funci.PNG)

Adicionalmente se realizaron cambios en la clase Galgo, para poder tratar con los temas que del monitor que manejaba el wait, estos cambios se muestran en dicha clase.
