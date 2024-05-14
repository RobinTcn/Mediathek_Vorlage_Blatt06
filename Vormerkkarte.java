package de.uni_hamburg.informatik.swt.se2.mediathek.ui.subwerkzeuge.vormerkmedienauflister;

import de.uni_hamburg.informatik.swt.se2.mediathek.entitaeten.Kunde;
import de.uni_hamburg.informatik.swt.se2.mediathek.entitaeten.medien.Medium;
import de.uni_hamburg.informatik.swt.se2.mediathek.wertobjekte.Datum;

/**
 * Mit Hilfe von Vormerkkarte werden beim Vormerken eines Mediums alle relevanten
 * Daten notiert.
 * 
 * Sie beantwortet die folgenden Fragen: Welches Medium wurde vorgemerkt? Wer
 * hat das Medium vorgemerkt? Wann wurde das Medium vorgemerkt?
 * 
 * Wenn Medium ausgeliehen wurden, kann die zugehörige Vormerkkarte entsorgt
 * werden. Um die Verwaltung der Karten kümmert sich der VerleihService
 * 
 * @author Gruppe 20 (BRNL)
 * @version SoSe 2024
 */
public class Vormerkkarte
{

    // Eigenschaften einer Vormerkkarte
    private final Datum _vormerkdatum;
    private final Kunde _vormerker;
    private final Medium _medium;

    /**
     * Initialisert einen neuen Vormerkkarte mit den gegebenen Daten.
     * 
     * @param vormerker Ein Kunde, der das Medium ausgeliehen hat.
     * @param medium Ein verliehene Medium.
     * @param vormerkdatum Ein Datum, an dem der Kunde das Medium ausgeliehen
     *            hat.
     * 
     * @require vormerker != null
     * @require medium != null
     * @require vormerkdatum != null
     * 
     * @ensure #getVormerker() == vormerker
     * @ensure #getMedium() == medium
     * @ensure #getVormerkdatum() == vormerkdatum
     */
    public Vormerkkarte(Kunde vormerker, Medium medium, Datum vormerkdatum)
    {
        assert vormerker != null : "Vorbedingung verletzt: entleiher != null";
        assert medium != null : "Vorbedingung verletzt: medium != null";
        assert vormerkdatum != null : "Vorbedingung verletzt: ausleihdatum != null";

        _vormerker = vormerker;
        _medium = medium;
        _vormerkdatum = vormerkdatum;
    }

    /**
     * Gibt das Vormerkdatum zurück.
     * 
     * @return Das Vormerkdatum.
     * 
     * @ensure result != null
     */
    public Datum getVormerkdatum()
    {
        return _vormerkdatum;
    }

    /**
     * Gibt den Vormerker zurück.
     * 
     * @return den Kunden, der das Medium vorgemerkt hat.
     * 
     * @ensure result != null
     */
    public Kunde getVormerker()
    {
        return _vormerker;
    }

    /**
     * Gibt eine String-Darstellung der Vormerkkarte (enhält Zeilenumbrüche)
     * zurück.
     * 
     * @return Eine formatierte Stringrepäsentation der Vormerkkarte. Enthält
     *         Zeilenumbrüche.
     * 
     * @ensure result != null
     */
    public String getFormatiertenString()
    {
        return _medium.getFormatiertenString() + "am "
                + _vormerkdatum.toString() + " vorgemerkt fuer\n"
                + _vormerker.getFormatiertenString();
    }

    /**
     * Gibt das Medium, dessen Ausleihe auf der Karte vermerkt ist, zurück.
     * 
     * @return Das Medium, dessen Ausleihe auf dieser Karte vermerkt ist.
     * 
     * @ensure result != null
     */
    public Medium getMedium()
    {
        return _medium;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((_vormerkdatum == null) ? 0 : _vormerkdatum.hashCode());
        result = prime * result
                + ((_vormerker == null) ? 0 : _vormerker.hashCode());
        result = prime * result + ((_medium == null) ? 0 : _medium.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean result = false;
        if (obj instanceof Vormerkkarte)
        {
            Vormerkkarte other = (Vormerkkarte) obj;

            if (other.getVormerkdatum()
                .equals(_vormerkdatum)
                    && other.getVormerker()
                        .equals(_vormerker)
                    && other.getMedium()
                        .equals(_medium))

                result = true;
        }
        return result;
    }

    @Override
    public String toString()
    {
        return getFormatiertenString();
    }
}
