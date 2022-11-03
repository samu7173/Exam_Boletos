# Exam_Boletos
Solución de examen realizado en DAM
Examen Programación en java en DAM (desarrollo de aplicaciones 
Multiplataforma)

La farmacia VIRGEN DE LA PAZ desea vender lotes de mascarillas entre sus clientes. Dispone de 
varios tipos de mascarilla y desea registrar en una aplicación ciertas características de cada una 
de ellas.
Así, en concreto, todas las mascarillas deben de almacenar la siguiente información:
• Reutilizable. Variable de tipo booleano que indica si la mascarilla se puede reutilizar o 
no.
• Tipo. Pudiendo ser FFP1, FPP2, FPP3, higiénica o quirúrgica.
• Nombre del fabricante.
• Código.
• Precio.
• Cantidad de mascarillas disponibles.
El programa almacenara un listado con las mascarillas dadas de alta en el sistema, pudiendo 
aumentar de forma indefinida. 
El programa tendrá las siguientes opciones que se describen a continuación:
1. Añadir Lote. Pedirá al usuario el código de la mascarilla. Si el código ya existe, 
preguntara la cantidad de mascarillas que desea añadir y actualizara la cantidad de esa 
mascarilla sumando la cantidad a la que ya había. Si el código no existe, sacaremos un
menú preguntando el tipo de mascarilla (FFP1, FFP2, FFP1, higiénica o quirúrgica) y 
pediremos la información que corresponda según el caso (fabricante, reutilizable, 
precio, tipo, cantidad,) añadiendo a la lista el nuevo modelo de la mascarilla. Todo se 
ira guardando en un fichero que se llamara lotes.txt.
2. Vender. Saldrá un menú preguntando el tipo de mascarilla que se desea comprar 
(FPP1, FPP2, FPP3, higiénico o quirúrgica) y a continuación se mostrará la información
de todas las mascarillas que tenemos del tipo elegido. Se preguntará por el código de 
la que queremos vender y a continuación se preguntará la cantidad que vamos a 
vender. Si la cantidad es mayor que la disponibilidad, se avisa y no se realizará la 
venta. Si la cantidad es menor o igual, se indicará el importe total y se actualizará la 
cantidad de mascarillas disponibles con ese código.
Cada venta se guardará en un archivo diario de texto.
3. Listar Todas. Mostrara un listado con toda la información de las mascarillas que hay en 
el listado.
4. Salir. Al pulsar esta opción se saldrá del programa.
