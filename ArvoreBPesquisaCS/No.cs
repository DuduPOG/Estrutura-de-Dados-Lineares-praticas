public class No
{
    private No pai;
    private No FE;
    private int value;
    private No FD;

    public No()
    {
        this.pai = null;
        this.FE = null;
        this.value = null;
        this.FD = null;
    }

    public setPai(No n)
    {
        this.pai = n;
    }

    public setFE(No n)
    {
        this.FE = n;
    }

    public setValue(No n)
    {
        this.value = n;
    }

    public setFD(No n)
    {
        this.FD = n;
    }

    public getPai()
    {
        return this.pai;
    }

    public getFE()
    {
        return this.FE;
    }

    public getValue()
    {
        return this.value;
    }

    public getFD()
    {
        return this.FD;
    }
}