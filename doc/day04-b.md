Esta variante elimina iterativamente los rollos 
accesibles hasta que no queden más. La clase 
IterativeRemover encapsula la iteración y delega 
la lógica de eliminación a PaperRemover, respetando 
SRP y OCP. ForkliftAccess sigue proporcionando la 
información de accesibilidad, desacoplando cálculo y acción.
Se aplica DRY al centralizar la eliminación y 
el conteo de rollos.