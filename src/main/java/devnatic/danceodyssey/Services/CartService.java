package devnatic.danceodyssey.Services;

import devnatic.danceodyssey.DAO.Entities.CART;
import devnatic.danceodyssey.DAO.Repositories.CartRepository;
import devnatic.danceodyssey.Interfaces.ICartService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CartService implements ICartService {
    private  final CartRepository cartRepository;
    @Override
    public CART getCartById(Integer cartId) {
        CART cart=cartRepository.findById(cartId).get();
       return cart;
}}
