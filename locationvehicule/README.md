Annotations SPRINGBOOT / JPA:

@EnableAutoConfiguration = configure automatiquement les beans (object représentant une entité, et dont les données sont représentées par des propriétés) dans le chemin de classe.
Le but est de simplifier le travail des développeurs en devinant les beans requis à partir du chemin de classe.

@Autowired = annotation qui permet de faire l'injection de dépendances entre les beans de l'application.

@SpringBootApplication = annotation utilisée pour marquer une classe de configuration qui déclare une ou plusieurs méthodes @Bean et déclenche également la configuration automatique et l'analyse des composants.

@Configuration = indique que la classe a des méthodes de définition @Bean.

@ComponentScan = spécifie les packages que l'on souhaite utiliser

@RestController = permet de simplifier la création de services Web RESTful (un combiné de @Controller et @ ResponseBody)

@RequestMapping = utilisé pour mapper les requêtes Web aux méthodes du Spring Controller

@RequestBody = annotation du paramètre method indique qu'un paramètre method doit être liée à la valeur du corps de la requête HTTP

@PathVariable = annotation pour extraire les valeurs de l'URI

@GetMapping = annotation composée qui agit comme raccourci pour @RequestMappin (method = RequestMethod.GET)
(idem pour @PostMapping, @PutMapping et @DeleteMapping)

@Repository = annotation utilisée pour indiquer que la classe fournit le mécanisme pour l'opération de stockage, de récupération, de recherche, de mise à jour et de suppression sur les objets



@Entity = indique que la classe est une classe persistante. Elle peut prendre un attribut name, qui fixe le nom de cette entité. Par défaut, le nom d'une entité est le nom complet de sa classe

@Id = permet de mmaper une clé primaire sur un champ unique 

@GeneratedValue = clé primaire générée de façon automatique lors de l'insertion en base

@Query = permet d'effectuer une requête

