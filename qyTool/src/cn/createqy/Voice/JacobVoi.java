package cn.createqy.Voice;

import cn.createqy.Exception.MemoryOverflow;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class JacobVoi {
    ActiveXComponent sap=null;
    Dispatch sapo=null;
    public JacobVoi()
    {
        sap = new ActiveXComponent("Sapi.Spvoice");
//语音朗读声音大小0-100
        sap.setProperty("Volume", new Variant(100));

// 语音朗读速度 -10 到 +10

        sap.setProperty("Rate", new Variant(0));

    }
    public void speak(String content)
    {
            sapo = sap.getObject();
// 执行朗读
            Dispatch.call(sapo, "Speak", new Variant(content));


    }

    @Override
    protected void finalize() throws Throwable {
        sapo.safeRelease();
        sap.safeRelease();
    }

    public void setLouder(int n) throws MemoryOverflow {
        if(n<0||n>100)
        {
            throw new MemoryOverflow();

        }
        sap.setProperty("Volume", new Variant(n));
    }
    public void setSpeed(int n) throws MemoryOverflow {
        if(n<-10||n>10)
        {
            throw new MemoryOverflow();
        }
        sap.setProperty("Rate", new Variant(n));
    }


}
