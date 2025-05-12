# Android MVVM + Jetpack Compose

## Aplicación Android con arquitectura MVVM + Jetpack Compose

El desarrollo moderno de aplicaciones Android se orienta hacia una arquitectura limpia, mantenible y reactiva. Google recomienda el uso de la arquitectura MVVM (Model-View-ViewModel) junto con Jetpack Compose, su moderno toolkit declarativo para construir interfaces de usuario. Esta combinación facilita el desarrollo eficiente, adaptable y escalable de aplicaciones móviles.

Esta pequeña aplicación consta de mostrar por pantalla un consejo junto con el nombre del autor. La idea de este proyecto es entender como funciona la arquitectura MVVM y como se integra con Jetpack Compose para mostrar datos que tienen la capacidad de cambiar de estado y actualizarse usando LiveData.

El funcionamiento es simple. Cuando la aplicación inicia, esta carga la UI construida por Compose, donde se inicializa el ViewModel de los consejos. Cuando se inicializa por primera vez, llama a la función 'randomAdvice()' que establece un nuevo 'AdviceModel' dentro del LiveData gracias al proveedor. Una vez se establece el nuevo objeto en el LiveData, la funcion 'observeAsState()' detecta que se ha modificado el valor, por lo que ejecuta 'state?.let {}', y todo lo que este dento de este lambda se volvera a ejecutar. Así que metemos dentro en este caso los 'Text' que se van a modificar.