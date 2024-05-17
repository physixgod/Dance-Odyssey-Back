package devnatic.danceodyssey.DAO.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StripeService{   Float amount;
  String name;
          String  cardNumber;
          String expDate;
          String cvc;
          String   stripeToken;


          }
