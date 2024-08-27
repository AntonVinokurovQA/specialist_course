package labthree;

public class SimpleParser extends ComLineParserBase {
    private String inFile, outFile;

    public SimpleParser(String[] keys) {
        super(keys);
    }

    public SimpleParser(String[] keys, String[] delimeters) {
        super(keys, delimeters);
    }

    @Override
    public SwitchStatus OnSwitch(String key, String keyValue) {
        SwitchStatus status = SwitchStatus.NoError;

        switch (key) {
            case "?":
                status = SwitchStatus.ShowUsage;
                break;
            case "r":
                if (keyValue != null && !keyValue.equals("")) {
                    inFile = keyValue;
                } else {
                    System.out.println("Empty value of " + key + "parameter.");
                    status = SwitchStatus.Error;
                }
                break;
            case "w":
                if (keyValue != null && !keyValue.equals("")) {
                    outFile = keyValue;
                } else {
                    System.out.println("Empty value of " + key + "parameter.");
                    status = SwitchStatus.Error;
                }
                break;
            default:
                System.out.println("Unknown parameter");
                status = SwitchStatus.Error;
        }

        return status;
    }

    @Override
    protected void OnUsage(String errorKey) {
        if (errorKey != null)
            System.out.println("Command-line switch error:" + errorKey);

        System.out.println("формат ком.строки: имяПрограммы [-r<input-fileName>] [-w<output-fileName>]");
        System.out.println("   -?  показать Help файл");
        System.out.println("   -r  задать имя входного файла");
        System.out.println("   -w  выполнить вывод в указанный файл");
    }

    public String getInFile() {
        return inFile;
    }

    public String getOutFile() {
        return outFile;
    }
}
