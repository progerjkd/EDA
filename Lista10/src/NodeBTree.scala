package Lista10

class NodeBTree (var chave:Array[Int], var parent:NodeBTree, var ramo:Array[NodeBTree], 
          var ndesc:Int, val MAX:Int, val Min:Int) {
  
  def this(){
    this(null, null, null,0,4,2)
    this.chave = new Array[Int](MAX+1)
    this.chave = this.chave.map(_-1) 
    this.parent = null
    this.ramo = new Array[NodeBTree](MAX+1)
    this.ndesc = 0
  }

  //Metodo da Questao 9
  def printBTreeSimetric(lim_inf:Int, lim_sup:Int,arv:NodeBTree=this){
    if(arv.!=(null)){
        for(i <- 0 until arv.ndesc){
          printBTreeSimetric(lim_inf, lim_sup, arv.ramo(i))
          if(arv.chave(i).>(lim_inf) && arv.chave(i).<(lim_sup))
            print(arv.chave(i) + " ")
        }
        printBTreeSimetric(lim_inf, lim_sup, arv.ramo(arv.ndesc))
    }
  }
  
  
  
  //--Metodos para insercao--//
  def insert(value:Int, arv:NodeBTree=this):NodeBTree={
    var arvAux:NodeBTree=arv
    //so tem raiz
    if(arvAux.ramo(0).==(null)){
        //raiz vazia
        if(arvAux.chave(0).==(-1)){
            arvAux.chave(0) = value
            arvAux.ndesc+=1
        }
        else{
            arvAux = insertLeaf(arvAux,value)
            while(arvAux.ndesc.==(MAX+1))
                arvAux = split(arvAux)
        }
    }
    //nao e na raiz
    else{
        arvAux = searchInsert(arvAux, value)
        // adiciona valor no no
        arvAux = insertLeaf(arvAux,value)
        //caso estoure a pagina
        while(arvAux.ndesc.==(MAX+1)){
          arvAux = split(arvAux)
        }
      }
    arvAux
   }
  
  //Acha folha onde o no deve ser inserido
  def searchInsert(Arv:NodeBTree, value:Int):NodeBTree={
    var arvAux:NodeBTree = Arv
    if(arvAux.ramo(0).!=(null)){
          for (i <- 0 until arvAux.ndesc){
               if(arvAux.chave(i).>(value)){
                 return searchInsert(arvAux.ramo(i), value)
               }
               if(i.==(arvAux.ndesc-1)){
                 return searchInsert(arvAux.ramo(ndesc), value)
               }
          }               
    }
    arvAux
  }
  
  //Insere no na folha
  def insertLeaf(Arv:NodeBTree,value:Int):NodeBTree={
    var arvAux:NodeBTree = Arv
    for(i <- 0 until arvAux.ndesc){
        if(arvAux.chave(i).>(value)){
          for(j <- i until arvAux.ndesc)
            arvAux.chave(j+1) = arvAux.chave(j)
          arvAux.chave(i) = value
          arvAux.ndesc+=1
        }
        else if(i.==(arvAux.ndesc-1)){
          arvAux.chave(arvAux.ndesc) = value
          arvAux.ndesc+=1
        }
    }
    arvAux
  }
  
  //Faz o split se necessario
  def split(Arv:NodeBTree, left:NodeBTree = null, right:NodeBTree=null, value:Int=0):NodeBTree={
    var arvAux:NodeBTree = Arv
    
    
    //Novos nos
    var arvAux2:NodeBTree = new NodeBTree()
    var arvAux3:NodeBTree = new NodeBTree()
    
    //Quando o no nao terminal e nao raiz vai ser particionado
    if(left.!=(null) && right.!=(null) && value.!=(0)){
      insertLeaf(arvAux, value)
    }
      
    //Novo filho esquerdo
    for(i <- 0 until (arvAux.ndesc/2)){
      arvAux2.chave(i) = arvAux.chave(i)
      arvAux2.ndesc+=1
    }
    
    //Novo filho direito
    for(i <-(arvAux.ndesc/2)+1 until arvAux.ndesc){
      arvAux3.chave(arvAux3.ndesc) = arvAux.chave(i)
      arvAux3.ndesc+=1
    }
    
    //Quando o no nao terminal e nao raiz vai ser particionado
    if(left.!=(null) && right.!=(null) && value.!=(0)){
      for(i <- 0 to arvAux.MAX/2){
        arvAux2.ramo(i) = arvAux.ramo(i)  
      }
      for(i <- ((arvAux.MAX/2)+1) until arvAux.MAX){
        arvAux3.ramo(i-((arvAux.MAX/2)+1)) = arvAux.ramo(i)  
      }
      arvAux3.ramo(arvAux3.ndesc-1) = left
      arvAux3.ramo(arvAux3.ndesc) = right
      left.parent = arvAux3
      right.parent = arvAux3
    }
       
    //nova raiz
    if(arvAux.parent.==(null)){
      
      var arvNewRoot: NodeBTree = new NodeBTree()
      arvNewRoot.chave(0) = arvAux.chave(ndesc/2)
      arvNewRoot.ndesc+=1
      arvNewRoot.ramo(0) = arvAux2
      arvNewRoot.ramo(1) = arvAux3
      arvAux2.parent = arvNewRoot
      arvAux3.parent = arvNewRoot
      return arvNewRoot
    }
    //Sem nova raiz
    else{
      var nodeParent:Int = 0
      for(i <- 0 to arvAux.parent.ndesc){
        if(arvAux.parent.ramo(i).==(arvAux))
          nodeParent = i
      }
      for(i <- arvAux.parent.ndesc to nodeParent + 1 by -1){
        arvAux.parent.ramo(i+1) = arvAux.parent.ramo(i) 
      }
      
      if(nodeParent.<(MAX)){
        arvAux.parent.ramo(nodeParent) = arvAux2
        arvAux.parent.ramo(nodeParent+1) = arvAux3
        arvAux2.parent = arvAux.parent
        arvAux3.parent = arvAux.parent
        //Adicione a chave no pai
        return insertLeaf(arvAux.parent, arvAux.chave(arvAux.ndesc/2))
      }
      else
        return split(arvAux.parent, arvAux2, arvAux3, arvAux.chave(arvAux.ndesc/2))
    }
  }
  
}