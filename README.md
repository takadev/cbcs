# JavaCCの正規表現

種類|記述例
--|--
固定文字列|"int"
連接|"ABC" "XYZ"
文字クラス|["X","Y","Z"]
文字範囲による文字クラス|["0"-"9"]
否定文字クラス|^["X","Y","Z"]
任意の1文字|^[]
0回以上の繰り返し|("o")*
1回以上の繰り返し|("o")+
n回からm回の繰り返し|("o"){1,3}
ちょうどn回の繰り返し|("o"){3}
省略可能|("0x")?
選択|"ABC"&#x7C;"XYZ"


# JavaCCのEBNF記法

種類|記述例
--|--
終端記号|<IDENTIFIER>または","
非終端記号|name()
連接|<UNSIGNED> <LONG>
0回以上の繰り返し|("," expr())*
1回以上の繰り返し|(stmt())+
選択|<CHAR> &#x7C;<SHORT>&#x7C;<INT>&#x7C;<LONG>
省略可能|[<ELSE> stmt()]


# 意味値を取り出す

```
String name():
{
    Token tok;
}
{
    tok=<IDENTIFIER> { return tok.image; }
}
```

```
意味値の型 非終端記号名(パラメータリスト):
{
    ローカル変数宣言
}
{
    規則とアクション
}
```

# Nodeクラス群の継承階層

```
Node
    AST
    ExprNode
        AbstractAssignNode
            AssignNode
            OpAssignNode
        AddressNode
        BinaryOpNode
            LogicalAndNode
            LogicalOrNode
        CastNode
        CondExprNode
        FuncallNode
        LHSNode
            ArefNode
            DereferenceNode
            MemberNode
            PtrMemberNode
            VariableNode
        LiteralNode
            IntegerLiteralNode
            StringLiteralNode
        SizeofExprNode
        SizeofTypeNode
        UnaryOpNode
            UnaryArithmeticOpNode
                PrefixOpNode
                SuffixOpNode
    Slot
    StmtNode
        BlockNode
        BreakNode
        CaseNode
        ContinueNode
        DoWhileNode
        ExprStmtNode
        ForNode
        GotoNode
        IfNode
        LabelNode
        ReturnNode
        SwitchNode
        WhileNode
    TypeDefinition
        CompositeTypeDefinition
            StructNode
            UnionNode
        TypedefNode
    TypeNode
```

# Typeクラスの階層

```
Type
    ArrayType
    FunctionType
    IntegerType
    NamedType
        CompositeType
            StructType
            UnionType
        UserType
    PointerType
    VoidType
```

# TypeRefクラスの継承階層

```
TypeRef
    ArrayTypeRef
    FunctionTypeRef
    IntegerTypeRef
    PointerTypeRef
    StructTypeRef
    UnionTypeRef
    UserTypeRef
    VoidTypeRef
```
