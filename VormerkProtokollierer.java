package de.uni_hamburg.informatik.swt.se2.mediathek.ui.subwerkzeuge.vormerkmedienauflister;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import de.uni_hamburg.informatik.swt.se2.mediathek.services.verleih.ProtokollierException;

/**
 * Ein Vormerkprotokollierer schreibt alle Verleihvorgänge in eine Datei.
 * 
 * @author BRNL
 * @version SoSe 2024
 */
class VormerkProtokollierer
{
    /**
     * Textrepräsentation für das Ereignis Ausleihe
     */
    public static final String EREIGNIS_VORMERKEN = "Vormerkung";

    /**
     * Pfad der Datei, in die das Verleihprotokoll geschrieben wird
     */
    private static final String DATEIPFAD = "./verleihProtokoll.txt";

    /**
     * Schreibt eine übergebene Vormerkkarte ins Protokoll.
     * 
     * @param ereignis Der Name des Vormerkereignis: mögliche Namen ist durch
     *            die Konstante EREIGNIS_VORMERKUNG definiert
     * @param vormerkkarte eine Vormerkkarte, die das Verleihereignis betrifft.
     * 
     * @require EREIGNIS_VORMERKEN.equals(ereignis)
     * @require vormerkkarte != null
     * 
     * @throws ProtokollierException wenn das Protokollieren nicht geklappt hat.
     */
    public void protokolliere(String ereignis, Vormerkkarte vormerkkarte)
            throws ProtokollierException
    {
        assert EREIGNIS_VORMERKEN.equals(
                ereignis) : "Precondition failed: EREIGNIS_VORMERKEN.equals(ereignis)";
        assert vormerkkarte != null : "Precondition failed: vormerkkarte != null";

        String eintrag = Calendar.getInstance()
            .getTime()
            .toString() + ": " + ereignis + "\n"
                + vormerkkarte.getFormatiertenString();

        try (FileWriter writer = new FileWriter(DATEIPFAD, true))
        {
            writer.write(eintrag);
        }
        catch (IOException e)
        {
            throw new ProtokollierException(
                    "Beim Schreiben des Vormerkprotokolls ist ein Fehler aufgetreten.");
        }
    }
}
