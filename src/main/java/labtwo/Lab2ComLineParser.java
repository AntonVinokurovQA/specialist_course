package labtwo;

import java.util.Arrays;

public class Lab2ComLineParser {
    private String[] keys;
    private String[] delimiters;

    public Lab2ComLineParser(String[] keys, String[] delimiters) {
        this.keys = Arrays.copyOf(keys, keys.length);
        this.delimiters = Arrays.copyOf(delimiters, delimiters.length);
    }

    public Lab2ComLineParser(String[] keys) {
        this(keys, new String[]{"/", "-"});
    }

    public static void main(String[] args) {
        Lab2ComLineParser app = new Lab2ComLineParser(new String[]{"h", "r", "w"}, new String[]{"-", "+"});

        app.parse(new String[]{"-xOutfileName", "-rInfileName", "-hInfileName"});
    }

    public void onUsage(String errorKey) {
        if (errorKey != null) System.out.println("Wrong parameter " + errorKey);
        System.out.println("формат ком.строки: имяПрограммы [-r<input-fileName>] [-w<output-fileName>]");
        System.out.println("   -h  показать Help файл");
        System.out.println("   -r  задать имя входного файла");
        System.out.println("   -w  выполнить вывод в указанный файл");
    }

    public void h() {
        System.out.println("help");
    }

    public void r() {
        System.out.println("file name");
    }

    public void w() {
        System.out.println("output in file");
    }

    public SwitchStatus OnSwitch(String key, String keyValue) {
        System.out.println("Key: " + key + "\n Key value: " + keyValue);

        return SwitchStatus.NoError;
    }

    public boolean parse(String[] args) {
        SwitchStatus status = SwitchStatus.NoError;
        int argNum;

        if (args == null) {
            onUsage(null);
            return false;
        }

        for (argNum = 0; status == SwitchStatus.NoError && argNum < args.length; argNum++) {
            boolean isDelimeter = false;
            boolean isKey = false;

            for (int n = 0; !isDelimeter && (n < delimiters.length); n++) {
                isDelimeter = args[argNum].regionMatches(0, delimiters[n], 0, 1);

                if (isDelimeter) {
                    for (int keyNum = 0; !isKey && keyNum < keys.length; keyNum++) {
                        isKey = args[argNum].regionMatches(1, keys[keyNum], 0, 1);
                        if (isKey) break;
                    }
                    if (!isKey) {
                        status = SwitchStatus.Error;
                        break;
                    }
                    break;
                }
            }
            if (!isDelimeter || (isDelimeter && !isKey)) {
                status = SwitchStatus.Error;
                break;
            }
        }
        if (status == SwitchStatus.Error) onUsage((argNum == args.length) ? null : args[argNum]);
        if (status == SwitchStatus.NoError) return true;
        else return false;
    }

    private enum SwitchStatus {NoError, Error, ShowUsage}
}
