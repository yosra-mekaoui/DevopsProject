package tn.esprit.devops_project.services;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OperatorServiceImplTest {


    // niveau de test :test d'integration (utilisation de @SpringBootTest)
    @Autowired
    private OperatorServiceImpl operatorService;


    //nous utilisons le framework Mockito pour simuler le comportement de OperatorRepository
    @Autowired
    private OperatorRepository operatorRepository;

    @Test
    public void testAddOperator() {
        // Créer un nouvel opérateur
        Operator operator = new Operator();
        operator.setFname("oussama");
        operator.setLname("ghannay");
        operator.setPassword("9999");

        // Ajouter l'opérateur
        Operator savedOperator = operatorService.addOperator(operator);

        // Vérifier que l'opérateur ajouté a un ID non nul
        assertNotNull(savedOperator.getIdOperateur());

        // Vérifier que l'opérateur ajouté a les mêmes informations que l'opérateur d'origine
        assertEquals("oussama", (savedOperator).getFname());
        assertEquals("ghannay", savedOperator.getLname());
        assertEquals("9999", savedOperator.getPassword());
    }


    @Test
    public void testRetrieveOperator() {
        // Créer un nouvel opérateur
        Operator operator = new Operator();
        operator.setFname("Alice");
        operator.setLname("Smith");
        operator.setPassword("securepassword");

        // Ajouter l'opérateur à la base de données
        Operator savedOperator = operatorRepository.save(operator);

        // Récupérer l'opérateur par son ID
        Long operatorId = savedOperator.getIdOperateur();
        Operator retrievedOperator = operatorService.retrieveOperator(operatorId);

        // Vérifier que l'opérateur récupéré n'est pas nul
        assertNotNull(retrievedOperator);

        // Vérifier que l'opérateur récupéré a les mêmes informations que l'opérateur ajouté
        assertEquals("Alice", retrievedOperator.getFname());
        assertEquals("Smith", retrievedOperator.getLname());
        assertEquals("securepassword", retrievedOperator.getPassword());
    }











    // Test fonctionnel (Validation)
    // Méthode pour valider une adresse e-mail
    public boolean isValidEmail(String email) {
        // Expression régulière pour vérifier le format d'une adresse e-mail
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    @Test
    public void testValidEmail() {
        String validEmail = "johndoe@example.com";
        assertTrue(isValidEmail(validEmail));
    }

    @Test
    public void testInvalidEmail() {
        String invalidEmail = "invalid_email";
        assertFalse(isValidEmail(invalidEmail));
    }


    @Test
    public void testUpdateOperator() {
        // Créer un nouvel opérateur
        Operator operator = new Operator();
        operator.setFname("wiss");
        operator.setLname("gh");
        operator.setPassword("1234");

        // Ajouter l'opérateur à la base de données
        Operator savedOperator = operatorService.addOperator(operator);

        // Mettre à jour les informations de l'opérateur
        savedOperator.setFname("ali");
        savedOperator.setLname("aloulou");
        savedOperator.setPassword("4321");
        Operator updatedOperator = operatorService.updateOperator(savedOperator);

        // Récupérer l'opérateur mis à jour par son ID
        Long operatorId = updatedOperator.getIdOperateur();
        Operator retrievedOperator = operatorService.retrieveOperator(operatorId);

        // Vérifier que les informations de l'opérateur ont été correctement mises à jour
        assertEquals("ali", retrievedOperator.getFname());
        assertEquals("aloulou", retrievedOperator.getLname());
        assertEquals("4321", retrievedOperator.getPassword());
    }



}