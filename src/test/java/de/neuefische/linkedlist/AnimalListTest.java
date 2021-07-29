package de.neuefische.linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class AnimalListTest {

    @Test
    public void toStringOfEmptyListReturnsEmptyString(){
        // GIVEN
        AnimalList list = new AnimalList();

        // WHEN
        String actual = list.toString();

        // THEN
        assertEquals("", actual);
    }

    @Test
    public void testAddToList(){
        // GIVEN
        Animal dog = new Animal("dog");
        Animal cat = new Animal("cat");
        Animal mouse = new Animal("mouse");
        AnimalList list = new AnimalList();

        // WHEN
        list.add(dog);
        list.add(cat);
        list.add(mouse);
        String actual = list.toString();

        // THEN
        String expected = "dog -> cat -> mouse";
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("provideTestRemoveArguments")
    public void testRemoveItemsFromList(String description, String[] animalNames, String animalNameToRemove, String expected){
        // GIVEN
        AnimalList list = new AnimalList();
        for(String animalName: animalNames){
            list.add(new Animal(animalName));
        }

        // WHEN
        list.remove(new Animal(animalNameToRemove));
        String actual = list.toString();

        // THEN
        assertEquals(expected, actual);
    }

    private static Arguments[] provideTestRemoveArguments(){
        return new Arguments[]{
                Arguments.of("Remove only element", new String[]{"dog"}, "dog", ""),
                Arguments.of("Remove 1 from  head", new String[]{"dog","cat","mouse"}, "dog", "cat -> mouse"),
                Arguments.of("Remove 1 from middle",new String[]{"dog","cat","mouse"}, "cat", "dog -> mouse"),
                Arguments.of("Remove 1 from last", new String[]{"dog","cat","mouse"}, "mouse", "dog -> cat"),
                Arguments.of("Remove 2 consecutive",new String[]{"cat","dog","dog","cat","mouse"}, "dog", "cat -> cat -> mouse"),
                Arguments.of("Remove 2 from head",new String[]{"dog","dog","cat","dog","mouse","dog"}, "dog", "cat -> mouse"),
        };
    }
}