package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IrisColumnsTest {

    @Test
    void columns_should_match_what_is_expected() {
        assertEquals("sepalLength", IrisColumns.SEPAL_LENGTH.getColumn().getName());
        assertEquals("sepalWidth", IrisColumns.SEPAL_WIDTH.getColumn().getName());
        assertEquals("petalLength", IrisColumns.PETAL_LENGTH.getColumn().getName());
        assertEquals("petalWidth", IrisColumns.PETAL_WIDTH.getColumn().getName());
        assertEquals("variety", IrisColumns.VARIETY.getColumn().getName());
    }

    @Test
    void values_should_return_all_columns() {
        IrisColumns[] col = new IrisColumns[]{
                IrisColumns.SEPAL_LENGTH,
                IrisColumns.SEPAL_WIDTH,
                IrisColumns.PETAL_LENGTH,
                IrisColumns.PETAL_WIDTH,
                IrisColumns.VARIETY};

        assertArrayEquals(col, IrisColumns.values());
    }


}