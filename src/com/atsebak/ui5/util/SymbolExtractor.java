package com.atsebak.ui5.util;

public final class SymbolExtractor {

    /**
     * Private constructor
     */
    private SymbolExtractor() {

    }
    /**
     * Extracts character sequence base on the position
     * @param charSequence
     * @param position
     * @return
     */
    public static String extract(CharSequence charSequence, int position) {
        if (position > charSequence.length()) {
            throw new IllegalStateException();
        }
        if (position < 0) {
            throw new IllegalStateException();
        }

        int first = position;
        for (int c = position - 1; c >= 0; c--) {
            if (Character.isJavaIdentifierPart(charSequence.charAt(c))) {
                first = c;
            } else {
                break;
            }
        }

        int last = position;
        for (int c = last; c <= charSequence.length(); c++) {
            if (c == charSequence.length() || !Character
                    .isJavaIdentifierPart(charSequence.charAt(c))) {
                last = c;
                break;
            }
        }

        return charSequence.subSequence(first, last).toString();
    }
}
