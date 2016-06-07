package Mascaras;

/**
 *
 * @author Shelmo
 */
public class pesquisarPalavrasSimilares
{

    public static float checkSimilarity(String sString1, String sString2) throws Exception
    {
            int iDiff = Math.abs(sString1.length() - sString2.length());
            int iLen = Math.max(sString1.length(), sString2.length());
            String sBigger, sSmaller, sAux;

            if (iLen == sString1.length())
            {
                sBigger = sString1;
                sSmaller = sString2;
            }
            else
            {
                sBigger = sString2;
                sSmaller = sString1;
            }

            float fSim, fMaxSimilarity = Float.MIN_VALUE;
            for (int i = 0; i <= sSmaller.length(); i++)
            {
                sAux = sSmaller.substring(0, i) + sBigger.substring(i, i + iDiff) + sSmaller.substring(i);
                fSim = 0;//checkSimilaritySameSize(sBigger, sAux);
                if (fSim > fMaxSimilarity)
                {
                    fMaxSimilarity = fSim;
                }
            }
            return fMaxSimilarity - (1f * iDiff) / iLen;
    }

    public static boolean checkSimilaritySameSize(String sString1, String sString2)
    {
        if (sString1.equalsIgnoreCase(sString2))
        {
            return true;
        }

        return false;
    }
}
