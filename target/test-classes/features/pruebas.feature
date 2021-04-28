@ApruebaDeIngreso
Feature: En este escenario se haran las pruebas de ingreso

  @T001
  Scenario Outline: Validar boto contact us
    Given Ingresar a la pagina web
    When seleccionar contact us
    And realizar registro completo <SubjectHeading> <EmailAddress> <OrderReference> <AttachFile> <Menssage>
    Then verificar registro exitoso

    Examples: 
      | SubjectHeading | EmailAddress        | OrderReference | AttachFile                              | Menssage                           |
      | "Webmaster"    | "pruebas@gmail.com" | "77896AH"      | "C:\\Users\\david\\Pictures\\foto.jpg" | "No se registra mi pago 23442#45." |

    