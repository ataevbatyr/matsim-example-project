package org.matsim.analysis2;

import org.matsim.api.core.v01.population.Population;
import org.matsim.core.population.PopulationUtils;

public class SimpleExperiencedPlansReader {
    static void main() {
        Population population = PopulationUtils.readPopulation("/Users/batyrataev/Downloads/output_experienced_plans (1).xml.zst");

        // count number of people
        int size = population.getPersons().size();

        System.out.println("Population size is " + size);
    }
}
