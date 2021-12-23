# ChallengeSOFKA
Sistema que simula un concurso de preguntas y respuesta, se cuenta con un banco de preguntas  con 5 categorías, Extrafácil, fácil, medio, díficil y extremo cada una asigna 10,20,30,40,50 puntos respectivamente. Se tienen 5 preguntas por cada categoría.

Cada banco de preguntas está dividida en categorias almacenadas en archivos de texto, y con un formato establecido previamente para facilitar su lectura, como se muestra a continuación:
;P;¿Cuál es la ciudad italiana conocida como “la novia del mar”?   --> Hace referencia a la pregunta
Venecia     --> Todas las opciones de la pregunta
Roma
Milán
Nápoles
;R;1        --> Número de ubicación de la respuesta
40          --> Puntos por acertar dicha pregunta.

Al iniciar el juego, se pide el nombre con el que se desea identificar.
Se le asignan aleatoriamente una pregunta de cada nivel de dificultad al usuario, si acierta continua el juego, si no, se reinicia el mismo.
Se guarta un historico con el detalle de cada partida en un fichero de texto.
