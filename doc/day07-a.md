Se implementa un solver que simula la propagación 
de un rayo en un manifold de posiciones. La clase 
TachyonSolver maneja la lógica de pasos y divisiones 
de rayos (^), usando Beam y SplitResult para representar 
el estado.
Se respeta SRP, separando parsing (TachyonSolverFactory) 
y ejecución.