package labone;

public class Lab1ConverterIntToBinary {
    public String getBinary(int number) {
        StringBuilder binary = new StringBuilder();

        for (int i = 0; i < 32; i++) {
            binary.append(number & 1);
            number >>= 1;
            if (i == 7 || i == 15 || i == 23) binary.append(" ");
        }

        return binary.toString();
    }
}
