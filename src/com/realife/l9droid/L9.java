package com.realife.l9droid;

//started: 01.09.2012

//char		16 bit
//byte		signed 8 bit	->	L9BYTE		unsigned 8 bit quantity
//short 	signed 16 bit	->	L9UINT16	unsigned 16 bit quantity
//int		signed 32 bit	->	L9UINT32	unsigned 32 bit quantity
//boolean					->	L9BOOL		quantity capable of holding the values TRUE (1) and FALSE (0)
//
//0=false
//1=true 

public class L9 {
	
	int showtitle=1;
	
	//GameState workspace;
	GameState workspace;
	//L9UINT16 randomseed;
	short randomseed;
	//L9BOOL Running;
	boolean Running;
	
	//char LastGame[MAX_PATH];
	String LastGame;
	

//// "L901"
//#define L9_ID 0x4c393031
//
//#define IBUFFSIZE 500
//#define RAMSAVESLOTS 10
//#define GFXSTACKSIZE 100
//
//
//// Typedefs
//typedef struct
//{
//	L9UINT16 vartable[256];
//	L9BYTE listarea[LISTAREASIZE];
//} SaveStruct;
//
//typedef struct
//{
//	L9BYTE *a5;
//	int scale;
//} GfxState;
//
//
//// Enumerations 
//enum L9GameTypes {L9_V1,L9_V2,L9_V3,L9_V4};
//enum V2MsgTypes {V2M_NORMAL,V2M_ERIK};
//

// Global Variables
//L9BYTE* startfile=NULL,*pictureaddress=NULL,*picturedata=NULL;
//L9BYTE* startdata;
//L9UINT32 FileSize,picturesize;
//
//L9BYTE *L9Pointers[12];
//L9BYTE *absdatablock,*list2ptr,*list3ptr,*list9startptr,*acodeptr;
//L9BYTE *startmd,*endmd,*endwdp5,*wordtable,*dictdata,*defdict;
//L9UINT16 dictdatalen;
//L9BYTE *startmdV2;
//
	int wordcase;
//int unpackcount;
//char unpackbuf[8];
//L9BYTE* dictptr;
//char threechars[34];
//int L9GameType;
//int V2MsgType;
//
//SaveStruct ramsavearea[RAMSAVESLOTS];
//
//char ibuff[IBUFFSIZE];
//L9BYTE* ibuffptr;
//char obuff[34];
//
	boolean Cheating=false;
//int CheatWord;
//GameState CheatWorkspace;
//
//int reflectflag,scale,gintcolour,option;
//int l9textmode=0,drawx=0,drawy=0,screencalled=0;
//L9BYTE *gfxa5=NULL;
//L9BOOL scalegfx=TRUE;
//Bitmap* bitmap=NULL;
//
//GfxState GfxStack[GFXSTACKSIZE];
//int GfxStackPos=0;
//
	char lastchar='.';
	char lastactualchar=0;
	int d5;
//
//L9BYTE* codeptr;	// instruction codes 
//L9BYTE code;		// instruction codes 
//
//L9BYTE* list9ptr;
//
//int unpackd3;
//
//L9BYTE exitreversaltable[16]= {0x00,0x04,0x06,0x07,0x01,0x08,0x02,0x03,0x05,0x0a,0x09,0x0c,0x0b,0xff,0xff,0x0f};
//
//L9UINT16 gnostack[128];
//L9BYTE gnoscratch[32];
//int object,gnosp,numobjectfound,searchdepth,inithisearchpos;


	
	L9() {
		workspace=new GameState();		
	};
	
	/*-- was ------------------------------------------
	L9BOOL LoadGame(char *filename,char *picname)
	{
		L9BOOL ret=LoadGame2(filename,picname);
		showtitle=1;
		clearworkspace();
		workspace.stackptr=0;
		// need to clear listarea as well
		memset((L9BYTE*) workspace.listarea,0,LISTAREASIZE);
		return ret;
	}
	*/
	public boolean LoadGame(String fileName, String picName) {
		
		boolean ret=LoadGame2(fileName, picName);
		showtitle=1;
		clearworkspace();
		workspace.stackptr=0;
		/* need to clear listarea as well */
		//TODO: ��������, �������� ����� �������� ������� - ����� memset
		//TODO: ������ ��������� ������� � ����� GameState
		for (int i=0;i<workspace.listarea.length;i++) workspace.listarea[i]=0;
		return ret;

	}
	
	public boolean RunGame() {
		return true;
	}
	
	public void StopGame () {
		
	}
	
	public void RestoreGame(String inFile) {
		
	}
	
	public void FreeMemory() {
		
	}
	
	//TODO: void GetPictureSize(int* width, int* height)
	//TODO: L9BOOL RunGraphics(void)
	//TODO: BitmapType DetectBitmaps(char* dir)
	//TODO: Bitmap* DecodeBitmap(char* dir, BitmapType type, int num, int x, int y)
	
////////////////////////////////////////////////////////////////////////

	void os_printchar(char c) {};
	//L9BOOL os_input(char* ibuff, int size)
	//char os_readchar(L9UINT32 millis)
	//L9BOOL os_stoplist(void)
	//void os_flush(void)
	//L9BOOL os_save_file(L9BYTE* Ptr, int Bytes)
	//L9BOOL os_load_file(L9BYTE* Ptr, int* Bytes, int Max)
	//L9BOOL os_get_game_file(char* NewName, int Size)
	//void os_set_filenumber(char* NewName, int Size, int n)
	//void os_graphics(int mode)
	//void os_cleargraphics(void)
	//void os_setcolour(int colour, int index)
	//void os_drawline(int x1, int y1, int x2, int y2, int colour1, int colour2)
	//void os_fill(int x, int y, int colour1, int colour2)
	//void os_show_bitmap(int pic, int x, int y)
	
////////////////////////////////////////////////////////////////////////
	
	/*-- was ----------------
	void clearworkspace(void)
	{
		memset(workspace.vartable,0,sizeof(workspace.vartable));
	}
	*/
	private void clearworkspace() 	{
		//TODO: ��������, �������� ����� �������� ������� - ����� memset
		//TODO: ������ ��������� ������� � ����� GameState
		//memset(workspace.vartable,0,sizeof(workspace.vartable));
		for (int i=0;i<workspace.vartable.length;i++) workspace.vartable[i]=0; 
	}
	
	/*-- was -------------------------------------
	L9BOOL LoadGame2(char *filename,char *picname)
	{
	#ifdef CODEFOLLOW
		f=fopen(CODEFOLLOWFILE,"w");
		fprintf(f,"Code follow file...\n");
		fclose(f);
	#endif

		// may be already running a game, maybe in input routine 
		Running=FALSE;
		ibuffptr=NULL;

	//  intstart 
		if (!intinitialise(filename,picname)) return FALSE;
	// 	if (!checksumgamedata()) return FALSE; 

		codeptr=acodeptr;
		randomseed=(L9UINT16)time(NULL);
		strcpy(LastGame,filename);
		return Running=TRUE;
	}
	*/
	boolean LoadGame2(String filename, String picname) {
		// may be already running a game, maybe in input routine
		Running=false;
		//TODO: ibuffptr=NULL;
		if (!intinitialise(filename,picname)) return false;
		//TODO: codeptr=acodeptr;
		randomseed = (short)(Math.random()*32767);
		LastGame=filename;
		Running=true;
		return Running;
	}
	
	/*-- was --------------------------------------
	L9BOOL intinitialise(char*filename,char*picname)
	{
	// init 
	// driverclg 

		int i;
		int hdoffset;
		long Offset;
		FILE *f;

		if (pictureaddress)
		{
			free(pictureaddress);
			pictureaddress=NULL;
		}
		picturedata=NULL;
		picturesize=0;
		gfxa5=NULL;

		if (!load(filename))
		{
			error("\rUnable to load: %s\r",filename);
			return FALSE;
		}

		// try to load graphics
		if (picname)
		{
			f=fopen(picname,"rb");
			if (f)
			{
				picturesize=filelength(f);
				L9Allocate(&pictureaddress,picturesize);
				if (fread(pictureaddress,1,picturesize,f)!=picturesize)
				{
					free(pictureaddress);
					pictureaddress=NULL;
					picturesize=0;
				}
				picturedata=pictureaddress;
				fclose(f);
			}
		}
		screencalled=0;
		l9textmode=0;

	#ifdef FULLSCAN
		FullScan(startfile,FileSize);
	#endif

		Offset=Scan(startfile,FileSize);
		if (Offset<0)
		{
			Offset=ScanV2(startfile,FileSize);
			L9GameType=L9_V2;
			if (Offset<0)
			{
				Offset=ScanV1(startfile,FileSize);
				L9GameType=L9_V1;
				if (Offset<0)
				{
					error("\rUnable to locate valid header in file: %s\r",filename);
				 	return FALSE;
				}
			}
		}

		startdata=startfile+Offset;
		FileSize-=Offset;

	// setup pointers 
		if (L9GameType!=L9_V1)
		{
			// V2,V3,V4 

			hdoffset=L9GameType==L9_V2 ? 4 : 0x12;

			for (i=0;i<12;i++)
			{
				L9UINT16 d0=L9WORD(startdata+hdoffset+i*2);
				L9Pointers[i]= (i!=11 && d0>=0x8000 && d0<=0x9000) ? workspace.listarea+d0-0x8000 : startdata+d0;
			}
			absdatablock=L9Pointers[0];
			list2ptr=L9Pointers[3];
			list3ptr=L9Pointers[4];
			//list9startptr 

			// if ((((L9UINT32) L9Pointers[10])&1)==0) L9Pointers[10]++; amiga word access hack

			list9startptr=L9Pointers[10];
			acodeptr=L9Pointers[11];
		}

		switch (L9GameType)
		{
			case L9_V1:
				break;
			case L9_V2:
			{
				double a2,a25;
				startmd=startdata + L9WORD(startdata+0x0);
				startmdV2=startdata + L9WORD(startdata+0x2);

				// determine message type 
				if (analyseV2(&a2) && a2>2 && a2<10)
				{
					V2MsgType=V2M_NORMAL;
					#ifdef L9DEBUG
					printf("V2 msg table: normal, wordlen=%.2lf",a2);
					#endif
				}
				else if (analyseV25(&a25) && a25>2 && a25<10)
				{
					V2MsgType=V2M_ERIK;
					#ifdef L9DEBUG
					printf("V2 msg table: Erik, wordlen=%.2lf",a25);
					#endif
				}
				else
				{
					error("\rUnable to identify V2 message table in file: %s\r",filename);
					return FALSE;
				}
				break;
			}
			case L9_V3:
			case L9_V4:
				startmd=startdata + L9WORD(startdata+0x2);
				endmd=startmd + L9WORD(startdata+0x4);
				defdict=startdata+L9WORD(startdata+6);
				endwdp5=defdict + 5 + L9WORD(startdata+0x8);
				dictdata=startdata+L9WORD(startdata+0x0a);
				dictdatalen=L9WORD(startdata+0x0c);
				wordtable=startdata + L9WORD(startdata+0xe);
				break;
		}

	#ifndef NO_SCAN_GRAPHICS
		// If there was no graphics file, look in the game data 
		if (picturedata==NULL)
		{
			int sz=FileSize-(acodeptr-startdata);
			int i=0;
			while ((i<sz-0x1000)&&(picturedata==NULL))
			{
				picturedata=acodeptr+i;
				picturesize=sz-i;
				if (!checksubs())
				{
					picturedata=NULL;
					picturesize=0;
				}
				i++;
			}
		}
	#endif
		return TRUE;
	}
	*/

	boolean intinitialise(String filename, String picname)
	{
	// init 
	// driverclg 
		/*TODO:
		int i;
		int hdoffset;
		long Offset;
		FILE *f;

		if (pictureaddress)
		{
			free(pictureaddress);
			pictureaddress=NULL;
		}
		picturedata=NULL;
		picturesize=0;
		gfxa5=NULL;
		*/
		if (!load(filename))
		{
			error("\rUnable to load: %s\r",filename);
			return false;
		}
		/*TODO:
		// try to load graphics
		if (picname)
		{
			f=fopen(picname,"rb");
			if (f)
			{
				picturesize=filelength(f);
				L9Allocate(&pictureaddress,picturesize);
				if (fread(pictureaddress,1,picturesize,f)!=picturesize)
				{
					free(pictureaddress);
					pictureaddress=NULL;
					picturesize=0;
				}
				picturedata=pictureaddress;
				fclose(f);
			}
		}
		screencalled=0;
		l9textmode=0;

	#ifdef FULLSCAN
		FullScan(startfile,FileSize);
	#endif

		Offset=Scan(startfile,FileSize);
		if (Offset<0)
		{
			Offset=ScanV2(startfile,FileSize);
			L9GameType=L9_V2;
			if (Offset<0)
			{
				Offset=ScanV1(startfile,FileSize);
				L9GameType=L9_V1;
				if (Offset<0)
				{
					error("\rUnable to locate valid header in file: %s\r",filename);
				 	return FALSE;
				}
			}
		}

		startdata=startfile+Offset;
		FileSize-=Offset;

	// setup pointers 
		if (L9GameType!=L9_V1)
		{
			// V2,V3,V4 

			hdoffset=L9GameType==L9_V2 ? 4 : 0x12;

			for (i=0;i<12;i++)
			{
				L9UINT16 d0=L9WORD(startdata+hdoffset+i*2);
				L9Pointers[i]= (i!=11 && d0>=0x8000 && d0<=0x9000) ? workspace.listarea+d0-0x8000 : startdata+d0;
			}
			absdatablock=L9Pointers[0];
			list2ptr=L9Pointers[3];
			list3ptr=L9Pointers[4];
			//list9startptr 

			// if ((((L9UINT32) L9Pointers[10])&1)==0) L9Pointers[10]++; amiga word access hack

			list9startptr=L9Pointers[10];
			acodeptr=L9Pointers[11];
		}

		switch (L9GameType)
		{
			case L9_V1:
				break;
			case L9_V2:
			{
				double a2,a25;
				startmd=startdata + L9WORD(startdata+0x0);
				startmdV2=startdata + L9WORD(startdata+0x2);

				// determine message type 
				if (analyseV2(&a2) && a2>2 && a2<10)
				{
					V2MsgType=V2M_NORMAL;
					#ifdef L9DEBUG
					printf("V2 msg table: normal, wordlen=%.2lf",a2);
					#endif
				}
				else if (analyseV25(&a25) && a25>2 && a25<10)
				{
					V2MsgType=V2M_ERIK;
					#ifdef L9DEBUG
					printf("V2 msg table: Erik, wordlen=%.2lf",a25);
					#endif
				}
				else
				{
					error("\rUnable to identify V2 message table in file: %s\r",filename);
					return FALSE;
				}
				break;
			}
			case L9_V3:
			case L9_V4:
				startmd=startdata + L9WORD(startdata+0x2);
				endmd=startmd + L9WORD(startdata+0x4);
				defdict=startdata+L9WORD(startdata+6);
				endwdp5=defdict + 5 + L9WORD(startdata+0x8);
				dictdata=startdata+L9WORD(startdata+0x0a);
				dictdatalen=L9WORD(startdata+0x0c);
				wordtable=startdata + L9WORD(startdata+0xe);
				break;
		}

	#ifndef NO_SCAN_GRAPHICS
		// If there was no graphics file, look in the game data 
		if (picturedata==NULL)
		{
			int sz=FileSize-(acodeptr-startdata);
			int i=0;
			while ((i<sz-0x1000)&&(picturedata==NULL))
			{
				picturedata=acodeptr+i;
				picturesize=sz-i;
				if (!checksubs())
				{
					picturedata=NULL;
					picturesize=0;
				}
				i++;
			}
		}
	#endif
		*/
		return true;
	}
	/*-- was ------------------
	L9BOOL load(char *filename)
	{
		FILE *f=fopen(filename,"rb");
		if (!f) return FALSE;
		FileSize=filelength(f);
		L9Allocate(&startfile,FileSize);

		if (fread(startfile,1,FileSize,f)!=FileSize)
		{
			fclose(f);
			return FALSE;
		}
	 	fclose(f);
		return TRUE;
	}
	*/
	
	boolean load(String filename)
	{
		//FILE *f=fopen(filename,"rb");
		//if (!f) return FALSE;
		//FileSize=filelength(f);
		//L9Allocate(&startfile,FileSize);
		//
		//if (fread(startfile,1,FileSize,f)!=FileSize)
		//{
		//	fclose(f);
		//	return FALSE;
		//}
	 	//fclose(f);
		//return TRUE;
		return false;
	}
	
	/*-- was ----------------
	void error(char *fmt,...)
	{
		char buf[256];
		int i;
		va_list ap;
		va_start(ap,fmt);
		vsprintf(buf,fmt,ap);
		va_end(ap);
		for (i=0;i< (int) strlen(buf);i++) os_printchar(buf[i]);
	}
	*/
	//TODO: error*3 - ������
	//TODO: ����� error �������� ���� �� ����������� ����?
	void error(String txt)
	{
		for (int i=0;i<txt.length();i++) os_printchar(txt.charAt(i));
	}
	
	void error(String txt1, String txt2)
	{
		String str=String.format(txt1, txt2);
		for (int i=0;i<str.length();i++) os_printchar(str.charAt(i));
	}

	void error(String txt, int val)
	{
		String str=String.format(txt, val);
		for (int i=0;i<str.length();i++) os_printchar(str.charAt(i));
	}

	/*--was---------------
	void printchar(char c)
	{
		if (Cheating) return;

		if (c&128) lastchar=(c&=0x7f);
		else if (c!=0x20 && c!=0x0d && (c<'\"' || c>='.'))
		{
			if (lastchar=='!' || lastchar=='?' || lastchar=='.') c=toupper(c);
			lastchar=c;
		}
		// eat multiple CRs
		if (c!=0x0d || lastactualchar!=0x0d) os_printchar(c);
		lastactualchar=c;
	}
	*/
	void printchar(char c)
	{
		if (Cheating) return;

		//if <128, Upper case after ".", "!", "?"
		if ((c&128)!=0) lastchar=(c&=0x7f);
		else if (c!=0x20 && c!=0x0d && (c<'\"' || c>='.'))
		{
			if (lastchar=='!' || lastchar=='?' || lastchar=='.') c=toupper(c);
			lastchar=c;
		}
		// eat multiple CRs
		if (c!=0x0d || lastactualchar!=0x0d) os_printchar(c);
		lastactualchar=c;
	}
 
	/*--was---------------
	void printstring(char*buf)
	{
		int i;
		for (i=0;i< (int) strlen(buf);i++) printchar(buf[i]);
	}
	*/
	void printstring(String str)
	{
		for (int i=0;i<str.length();i++) printchar(str.charAt(i));
	}
	
	/*--was---------------
	void printdecimald0(int d0)
	{
		char temp[12];
		sprintf(temp,"%d",d0);
		printstring(temp);
	}
	*/
	void printdecimald0(int d0)
	{
		printstring(String.valueOf(d0));
	}

	/*--was---------------
	void printautocase(int d0)
	{
		if (d0 & 128) printchar((char) d0);
		else
		{
			if (wordcase) printchar((char) toupper(d0));
			else if (d5<6) printchar((char) d0);
			else
			{
				wordcase=0;
				printchar((char) toupper(d0));
			}
		}
	}
	*/
	void printautocase(int d0)
	{
		if ((d0 & 128)!=0) printchar((char) d0);
		else
		{
			//TODO: check wordcase!=0
			if (wordcase!=0) printchar(toupper((char)d0));
			else if (d5<6) printchar((char) d0);
			else
			{
				wordcase=0;
				printchar(toupper((char)d0));
			}
		}
	}
	
	///////////////////// New (tsap) implementations ////////////////////
	
	char toupper(char c) {
		if (c>='a' && c<='z') return (char)(c-32);
		else return c;
	}

}

/*-------------
 typedef struct
{
	L9UINT32 Id;
	L9UINT16 codeptr,stackptr,listsize,stacksize,filenamesize,checksum;
	L9UINT16 vartable[256];
	L9BYTE listarea[LISTAREASIZE];
	L9UINT16 stack[STACKSIZE];
	char filename[MAX_PATH];
} GameState;

*/
class GameState {

	//TODO: ��������� LISTAREASIZE � STACKSIZE � ���������� ��������� 
	private static final int LISTAREASIZE = 0x800;
	private static final int STACKSIZE = 1024;
	
	int Id;
	short codeptr,stackptr,listsize,stacksize,filenamesize,checksum;
	short vartable[];
	byte listarea[];
	short stack[];
	String filename;
	
	GameState() {
		vartable=new short[256];
		listarea=new byte[LISTAREASIZE];
		stack=new short[STACKSIZE];
	}
	
}

