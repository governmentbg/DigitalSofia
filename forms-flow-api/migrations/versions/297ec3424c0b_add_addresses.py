"""Add addresses

Revision ID: 297ec3424c0b
Revises: ee93ee59714c
Create Date: 2023-05-11 12:01:33.942500

"""
from alembic import op
import sqlalchemy as sa


# revision identifiers, used by Alembic.
revision = '297ec3424c0b'
down_revision = 'ee93ee59714c'
branch_labels = None
depends_on = None


def upgrade():
    # ### commands auto generated by Alembic - please adjust! ###
    op.create_table('addresses_kra',
    sa.Column('created', sa.DateTime(), nullable=False),
    sa.Column('modified', sa.DateTime(), nullable=True),
    sa.Column('id', sa.Integer(), nullable=False),
    sa.Column('code_nm_grao', sa.String(), nullable=False),
    sa.Column('code_pa', sa.String(), nullable=False),
    sa.Column('name_pa', sa.String(), nullable=True),
    sa.Column('vid_pa', sa.Integer(), nullable=False),
    sa.Column('data_change', sa.String(), nullable=True),
    sa.Column('status', sa.Integer(), nullable=False),
    sa.PrimaryKeyConstraint('id')
    )
    op.create_table('region',
    sa.Column('created', sa.DateTime(), nullable=False),
    sa.Column('modified', sa.DateTime(), nullable=True),
    sa.Column('name', sa.String(), nullable=False),
    sa.Column('code', sa.String(), nullable=False),
    sa.Column('city_are_code', sa.Integer(), nullable=False),
    sa.Column('reference_number_code', sa.String(), nullable=False),
    sa.PrimaryKeyConstraint('city_are_code')
    )
    op.create_table('addresses_kad',
    sa.Column('created', sa.DateTime(), nullable=False),
    sa.Column('modified', sa.DateTime(), nullable=True),
    sa.Column('id', sa.Integer(), nullable=False),
    sa.Column('code_nm_grao', sa.String(), nullable=False),
    sa.Column('code_pa', sa.String(), nullable=False),
    sa.Column('building_number', sa.String(), nullable=False),
    sa.Column('entrance', sa.String(), nullable=True),
    sa.Column('region_id', sa.Integer(), nullable=False),
    sa.Column('section', sa.String(), nullable=False),
    sa.Column('division', sa.String(), nullable=True),
    sa.Column('post_code', sa.String(), nullable=False),
    sa.Column('num_permanent_address', sa.Integer(), nullable=True),
    sa.Column('num_present_address', sa.Integer(), nullable=True),
    sa.Column('date_change', sa.String(), nullable=True),
    sa.Column('status', sa.Integer(), nullable=False),
    sa.ForeignKeyConstraint(['region_id'], ['region.city_are_code'], ),
    sa.PrimaryKeyConstraint('id')
    )
    # ### end Alembic commands ###


def downgrade():
    # ### commands auto generated by Alembic - please adjust! ###
    op.drop_table('addresses_kad')
    op.drop_table('region')
    op.drop_table('addresses_kra')
    # ### end Alembic commands ###