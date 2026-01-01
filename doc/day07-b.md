Se calcula el número total de caminos posibles 
usando memoización (QuantumSolver) en lugar de 
simulación explícita. Cada posición se guarda en 
un Map para evitar recomputar subproblemas, 
aplicando OCP y DRY.
El solver reutiliza Manifold y Position, mientras 
la lógica recursiva con memoización permite un conteo
eficiente de caminos, separando claramente parsing 
(QuantumSolverFactory) y resolución.