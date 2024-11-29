package part2.service;

import part2.model.Alloy;

public interface AlloyOptimizationService {
    Alloy findBestCreepResistanceWithCost(Alloy alloy, double cost);
}


