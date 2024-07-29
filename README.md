# PROYECTO FINAL -ESTRUCTURA DE DATOS

![Logo](https://i.imgur.com/hvEOGF1.png)

## Descripción del problema

El desarrollo de una app en Java utilizando los conocimientos adquiridos en POO y estructura de datos como el MVC(modelo vista controlador) la creación de obstáculos que permitan implementar los metodos de búsqueda adecuados para recorrer el laberinto de inicio a fin.

## MarcoTeorico

### Dinámica

La programación dinámica es un metodo para resolver problemas complejos en problemas mas pequeños, resolviendo un problema pequeño a la vez y solo una vez creando una solución optima.

### BFS Y DFS

BFW(Breadh-First Search) y DFS(Depth-First Search) son algoritmos para recorrer árboles y grafos o buscar en elementos, el BFS revisa todos los nodos adyacentes antes de avanzar y el DFS explora a la mayor profundidad posible en el arbolo grafo.

### Descripción de la propuesta de solución,herramientas y/o lenguajes que usaron

Se está desarrollando una aplicación gráfica en Java, utilizando el entorno de Eclipse, que sigue el patrón de diseño Modelo-Vista-Controlador (MVC). La aplicación se divide en tres componentes principales:

- El Modelo: gestiona la lógica de la aplicación, incluyendo la creación de celdas y la implementación de algoritmos de búsqueda.
- La Vista: diseñada con la biblioteca Swing, presenta la interfaz gráfica al usuario, con elementos como ventanas, paneles y botones.
- El Controlador: actúa como puente entre el Modelo y la Vista, gestionando las interacciones del usuario y actualizando la interfaz según sea necesario.

Además, se ha implementado un método auxiliar para limpiar y reiniciar la aplicación, eliminando todas las celdas creadas. La biblioteca JOptionPane se utiliza para mostrar mensajes y notificaciones al usuario.

![ResultadoUI](.\src\\code.png)

## Criterio del estudiante

Juan Portilla: Hacer la interfaz de usuario mas intuitiva y crear pruebas unitarias de los metodos para facilitar la creacion de los metodos

## Capturas de la implementacion final de la UI

## Conclusiones

En la implementacion de los algoritmos de busqueda encontre que:

### BFS

El metodo BFS recorre todos los nodos de un nivel antes de avanzar al siguiente garantizando que se encuentre el camino mas corto

### DFS

El metodo DFS recorre toda la profundidad de la rama antes de volver, que parece ser mas rapido en la busqueda del camino.

### Cache

Al guardar el recorrido que ya se reviso, evita estar haciendo idas y vueltas innecesarias

### Normal

Es el mas simple de todos, solo busca la ruta mas eficiente sin recorrer de manera inncesario.

Por lo que el metodo de cache parece ser el mas eficiente a la hora de buscar la ruta evitando pasos inncesarios y devolviendo la ruta en menos tiempo que los otros metodos.

## Consideraciones

Juan Portilla: Documentar adecuadamente el codigo para futuras entregas para dejar una evidencia de la logica que se uso para crear cada metodo y su funcionalidad.
