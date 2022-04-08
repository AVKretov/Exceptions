package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.*;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Product first = new Book(1, "Мастер и Мрагарита", 350, "М.Булгаков", 560, 1966);
    private Product second = new TShirt(2, "Reebok", 1000, "Red", "L");
    private Product third = new Book(3, "Собачье сердце", 300, "М.Булгаков", 287, 1987);

    @BeforeEach
    public void shouldSetInitialState() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    public void shouldRemoveByExistentId() {

        repository.removeById(2);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, third};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldRemoveByNonExistentId() {

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(23);
        });
    }
}