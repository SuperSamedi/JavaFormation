package brussels.digitalcity.tu.exo.iban;

public class Iban {
    private String chain;

    public String getChain() {
        return chain;
    }

    public void setChain(String value) {
        chain = value;
    }

    public boolean checkValidity() throws IbanException{
        if ( getChain() == null ) throw new IbanException(MessageExceptionIban.STRING_NULL);
        setChain(getChain().replace(" ", "").replace("-", "").replace("_", ""));
        if ( getChain().length() < 16 ) throw new IbanException(MessageExceptionIban.STRING_TOO_SHORT);
        if ( getChain().length() > 16 ) throw new IbanException(MessageExceptionIban.STRING_TOO_LONG);
        if ( !getChain().startsWith("BE") ) throw new IbanException(MessageExceptionIban.STRING_WRONG_START);

        long evaluate;
        int check;
        try {
            long bban = Long.parseLong(getChain().substring(2, 15));
            evaluate = Long.parseLong(getChain().substring(4, 13));
            check = Integer.parseInt(getChain().substring(14, 15));
        }
        catch (NumberFormatException ex) {
            throw new IbanException(MessageExceptionIban.STRING_BBAN_WRONG_FORMAT);
        }

        if (check == 97 && evaluate % 97 != 0) throw new IbanException(MessageExceptionIban.STRING_CHECK_97_BAD_MODULO);
        if (check != 97 && evaluate % 97 != check) throw new IbanException(MessageExceptionIban.STRING_BBAN_BAD_MODULO);

        return true;
    }
}
