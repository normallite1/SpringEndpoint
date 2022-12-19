package ua.gnatyshyn.demo.service;

import org.springframework.stereotype.Service;
import ua.gnatyshyn.demo.Entity.Human;
import ua.gnatyshyn.demo.exeption.HumanNotFoundException;
import ua.gnatyshyn.demo.repo.HumanRepos;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class HumanService {

    private final HumanRepos humanRepos;

    public HumanService(HumanRepos humanRepos) {
        this.humanRepos = humanRepos;
    }

    public Optional<Human> findById(Long id){
        Human human = humanRepos.findById(id).orElseThrow(() -> new HumanNotFoundException(id));
        convertedBirthDayForYears(human);

        return Optional.of(human);
    }

    private static void convertedBirthDayForYears(Human human) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        human.setYears(
                String.valueOf(
                        Period.between(
                                LocalDate.parse(human.getYears(), formatter),
                                LocalDate.now()).getYears())
        );
    }

}
